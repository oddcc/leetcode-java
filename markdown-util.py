# -*- coding: UTF-8 -*-

import os
import json
import re
from tempfile import mkstemp
from shutil import move, copymode
from functools import cmp_to_key

BASE_DIR = os.path.dirname(os.path.realpath(__file__))
CODE_DIR = "leetcode-practice/src/main/java/com/oddcc/leetcode/editor/cn"
QUESTION_FILE = "all.json"
README_FILE = "README.md"
RE_FRONT_ID = re.compile('^// (.+)\\n$')
RE_SLUG = re.compile('^// .+&&(.+)\n$')
COMMENT_LINE = "<!--question list generated below here, don't DELETE this line-->\n"
HEADER = "|ID|标题|难度|CODE|\n"
SEPARATOR = "| ---- | ---- | ---- | ---- |\n"
QUESTION_INFO = "|{0}|{1}|{2}|{3}|\n"


def main():
    fh, tmp_path = mkstemp()
    readme_path = os.path.join(BASE_DIR, README_FILE)
    with os.fdopen(fh, 'w') as newFile:
        copy_from_old(newFile, readme_path)

        java_file_list = [j for j in os.listdir(os.path.join(BASE_DIR, CODE_DIR)) if j.endswith(".java")]
        data_dic_on_front_id = get_data_dic_on_front_id(os.path.join(BASE_DIR, QUESTION_FILE))
        data_dic_on_slug = get_data_dic_on_slug(os.path.join(BASE_DIR, QUESTION_FILE))
        q_list = get_question_list(java_file_list, data_dic_on_front_id, data_dic_on_slug)

        newFile.write("### 目前已有{}道题，不断添加中…\n".format(len(q_list)))
        newFile.write(HEADER)
        newFile.write(SEPARATOR)
        q_list.sort(key=cmp_to_key(question_sort))
        for q in q_list:
            newFile.write(cons_line(q))
        copymode(readme_path, tmp_path)
        os.remove(readme_path)
        move(tmp_path, readme_path)
        write_question_record(q_list)


def write_question_record(q_list):
    with open(os.path.join(BASE_DIR, "record"), 'w') as f:
        easy_count = 0
        medium_count = 0
        hard_count = 0
        total = 0
        for q in q_list:
            total += 1
            level = q["level"]
            if level == "EASY":
                easy_count += 1
            elif level == "MEDIUM":
                medium_count += 1
            else:
                hard_count += 1
        f.write("{}\n".format(total))
        f.write("{}\n".format(easy_count))
        f.write("{}\n".format(medium_count))
        f.write("{}\n".format(hard_count))


def copy_from_old(newFile, readme_path):
    with open(readme_path) as oldFile:
        for line in oldFile:
            newFile.write(line)
            if line == COMMENT_LINE:
                break


def cons_line(q):
    return QUESTION_INFO.format(
        "[{}](https://leetcode.cn/problems/{})".format(q["frontendQuestionId"], q["titleSlug"]),
        q["title"],
        "⭐" if q["level"] == "EASY" else "⭐⭐" if q["level"] == "MEDIUM" else "⭐⭐⭐",
        "[click](https://github.com/oddcc/leetcode-java/blob/master/leetcode-practice/src/main/java/com/oddcc/leetcode/editor/cn/{})".format(
            q["javaFile"]),
    )


def get_data_dic_on_front_id(data_file_path):
    with open(data_file_path) as dataFile:
        question_data = json.load(dataFile)
        ret_dic = {question_data[i]["frontendQuestionId"]: question_data[i]
                    for i in range(0, len(question_data))}
    return ret_dic


def get_data_dic_on_slug(data_file_path):
    with open(data_file_path) as dataFile:
        question_data = json.load(dataFile)
        ret_dic = {question_data[i]["titleSlug"]: question_data[i]
                   for i in range(0, len(question_data))}
    return ret_dic


def get_by_key(key, data_dic):
    return data_dic[key]

def get_question_list(java_file_list, data_dic_on_front_id, data_dic_on_slug):
    q_list = []
    for jFile in java_file_list:
        with open(os.path.join(CODE_DIR, jFile)) as j:
            line = j.readline()
            front_id_match = RE_FRONT_ID.match(line)
            slug_match = RE_SLUG.match(line)
            if (front_id_match is None) and (slug_match is None):
                print('need fix: {}, no leading comment line'.format(jFile))
                continue

            question = None
            if slug_match is not None:
                question = get_by_key(slug_match.group(1), data_dic_on_slug)
            else:
                question = get_by_key(front_id_match.group(1), data_dic_on_front_id)

            if question["status"] == "AC":
                question["javaFile"] = jFile
                q_list.append(question)
            else:
                print('[{}]{} is not ac yet: '.format(question['frontendQuestionId'], jFile))
    return q_list


def question_sort(q1, q2):
    key = "frontendQuestionId"
    id1 = q1[key]
    id2 = q2[key]
    if id1.isnumeric() and id2.isnumeric():
        return int(id1) - int(id2)
    elif id1.isnumeric():
        return -1
    else:
        if id1 < id2:
            return -1
        elif id1 > id2:
            return 1
        else:
            return 0


if __name__ == "__main__":
    main()
