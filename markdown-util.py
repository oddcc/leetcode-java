# -*- coding: UTF-8 -*-

import os
import json
import re
from tempfile import mkstemp
from shutil import move, copymode

BASE_DIR = os.path.dirname(os.path.realpath(__file__))
CODE_DIR = "src/main/java/com/oddcc/leetcode/editor/cn"
QUESTION_FILE = "all.json"
README_FILE = "README.md"
RE = re.compile('^\/\/ ([0-9]+)\\n$')
COMMENT_LINE = "<!--question list generated below here, don't DELETE this line-->\n"
HEADER = "|ID|标题|难度|CODE|\n"
SEPARATOR = "| ---- | ---- | ---- | ---- |\n"
QUESTION_INFO = "|{0}|{1}|{2}|{3}|\n"


def main():
    codePath = os.path.join(BASE_DIR, CODE_DIR)
    dataFilePath = os.path.join(BASE_DIR, CODE_DIR, QUESTION_FILE)

    with open(dataFilePath) as dataFile:
        questionData = json.load(dataFile)
        dataDic = {questionData[i]["frontendQuestionId"]: questionData[i]
                   for i in range(0, len(questionData))}
    javaFileList = [j for j in os.listdir(codePath) if j.endswith(".java")]

    fh, tmpPath = mkstemp()
    readmePath = os.path.join(BASE_DIR, README_FILE)
    with os.fdopen(fh, 'w') as newFile:
        with open(readmePath) as oldFile:
            for line in oldFile:
                newFile.write(line)
                if line == COMMENT_LINE:
                    break
            qList = []
            for jFile in javaFileList:
                with open(os.path.join(CODE_DIR, jFile)) as j:
                    firstLine = j.readline()
                    r = RE.match(firstLine)
                    if r is None:
                        print('need fix: ' + jFile)
                    else:
                        id = r.group(1)
                        qList.append(dataDic[id])
            newFile.write("目前已有{}道题，不断添加中…\n".format(len(qList)))
            newFile.write(HEADER)
            newFile.write(SEPARATOR)
            qList.sort(key=lambda q: int(q["frontendQuestionId"]))
            for q in qList:
                newFile.write(QUESTION_INFO.format(
                    q["frontendQuestionId"],
                    q["title"],
                    "easy" if q["level"] == 1 else "medium" if q["level"] == 2 else "hard",
                    "[url](baidu.com)",
                ))

            copymode(readmePath, tmpPath)
            os.remove(readmePath)
            move(tmpPath, readmePath)

if __name__ == "__main__":
    main()
