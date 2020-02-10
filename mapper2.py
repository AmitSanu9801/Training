#!/usr/bin/env python

import sys
import xml.etree.ElementTree as ET

def mapper():
    for row in sys.stdin:
        row = row.strip()
        if not row.startswith('<row'):
            continue
        
        parser = ET.fromstring(row)
        tags = parser.get('Tags')
        answers = parser.get('AnswerCount')

        # clean up tags, tags is a string with format "<tag1><tag2><tag3>...<tagX>"
        if tags:
            tags = tags.replace('<', ' ')
            tags = tags.replace('>', ' ')
            tags = tags.split()

        if isinstance(tags, list):
            for each in tags:
                print('{}\t{}'.format(each, answers))
        elif tags:
            print('{}\t{}'.format(tags, answers))

        # Maybe this will help with memory
        del parser

if __name__ == "__main__":
    mapper()
