# -*- coding: UTF-8 -*-

import os
import json
import re
from tempfile import mkstemp
from shutil import move, copymode
from functools import cmp_to_key

BASE_DIR = os.path.dirname(os.path.realpath(__file__))
CODE_DIR = "src/main/java/com/oddcc/leetcode/editor/cn"
QUESTION_FILE = "all.json"
README_FILE = "README.md"
# RE = re.compile('^// ([0-9]+)\\n$')
RE = re.compile('^// (.+)\\n$')
COMMENT_LINE = "<!--question list generated below here, don't DELETE this line-->\n"
HEADER = "|ID|标题|难度|CODE|\n"
SEPARATOR = "| ---- | ---- | ---- | ---- |\n"
QUESTION_INFO = "|{0}|{1}|{2}|{3}|\n"


def main():
    code_path = os.path.join(BASE_DIR, CODE_DIR)
    data_file_path = os.path.join(BASE_DIR, CODE_DIR, QUESTION_FILE)

    with open(data_file_path) as dataFile:
        question_data = json.load(dataFile)
        data_dic = {question_data[i]["frontendQuestionId"]: question_data[i]
                    for i in range(0, len(question_data))}
    java_file_list = [j for j in os.listdir(code_path) if j.endswith(".java")]

    fh, tmp_path = mkstemp()
    readme_path = os.path.join(BASE_DIR, README_FILE)
    with os.fdopen(fh, 'w') as newFile:
        with open(readme_path) as oldFile:
            for line in oldFile:
                newFile.write(line)
                if line == COMMENT_LINE:
                    break
            q_list = []
            for jFile in java_file_list:
                with open(os.path.join(CODE_DIR, jFile)) as j:
                    r = RE.match(j.readline())
                    if r is None:
                        print('need fix: ' + jFile)
                    else:
                        id = r.group(1)
                        question = data_dic[id]
                        question["javaFile"] = jFile
                        q_list.append(question)
            newFile.write("### 目前已有{}道题，不断添加中…\n".format(len(q_list)))
            newFile.write(HEADER)
            newFile.write(SEPARATOR)
            # q_list.sort(key=lambda q: int(q["frontendQuestionId"]))
            q_list.sort(key=cmp_to_key(question_sort))
            for q in q_list:
                newFile.write(QUESTION_INFO.format(
                    "[{}](https://leetcode-cn.com/problems/{})".format(q["frontendQuestionId"], q["titleSlug"]),
                    q["title"],
                    "easy" if q["level"] == 1 else "medium" if q["level"] == 2 else "hard",
                    "[click](https://github.com/oddcc/leetcode-java/blob/master/src/main/java/com/oddcc/leetcode/editor/cn/{})".format(
                        q["javaFile"]),
                ))

            copymode(readme_path, tmp_path)
            os.remove(readme_path)
            move(tmp_path, readme_path)


def question_sort(q1, q2):
    id1 = q1["frontendQuestionId"]
    id2 = q2["frontendQuestionId"]
    if id1.isnumeric() and id2.isnumeric():
        return int(id1) - int(id2)
    elif id1.isnumeric():
        return 1
    else:
        return id1 < id2


if __name__ == "__main__":
    main()
