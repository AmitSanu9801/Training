#!/usr/bin/env python

from __future__ import division
import sys

def reducer():

    tag_count = 0
    answer_count = 0
    old_tag = None
    for line in sys.stdin:
        data = line.strip().split("\t")
        if len(data) != 2:
            continue

        this_tag, count = data

        if old_tag and old_tag != this_tag:
            
            print("{}\t{:.3f}".format(old_tag, answer_count/tag_count))

            tag_count = 0
            answer_count = 0

        if old_tag and old_tag == this_tag:
            answer_count += int(count)
            
        old_tag = this_tag
        tag_count += 1
        

if __name__ == "__main__":
    reducer()
