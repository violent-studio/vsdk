# !!! generated by chatgpt !!!

import os
import argparse

def replace_in_file(file_path, keyword_pairs, log=False):
    with open(file_path, 'r', encoding='utf-8') as file:
        lines = file.readlines()

    with open(file_path, 'w', encoding='utf-8') as file:
        for line_number, line in enumerate(lines):
            for old, new in keyword_pairs:
                start_pos = 0
                while (start_pos := line.find(old, start_pos)) != -1:
                    if(log):print(f"{file_path}:{line_number+1}:{start_pos}: replaced {old} with {new} ({keyword_pairs.index((old, new)) + 1})")
                    line = line[:start_pos] + new + line[start_pos + len(old):]
                    start_pos += len(new)
            file.write(line)

def replace_in_directory(directory, keyword_pairs, log=False):
    for root, _, files in os.walk(directory):
        for file in files:
            file_path = os.path.join(root, file)
            replace_in_file(file_path, keyword_pairs, log)

def main():
    parser = argparse.ArgumentParser(description="Replace keywords in files within a directory or a single file.")
    parser.add_argument("path", type=str, help="The file or directory to search.")
    parser.add_argument("keywords", type=str, help="Keywords to replace, separated by $ (dollar sign).")
    parser.add_argument("replacements", type=str, help="Replacements, separated by $ (dollar sign).")
    parser.add_argument("--log", action="store_true", help="Log all replaced keywords.")
    
    args = parser.parse_args()

    keywords = args.keywords.split('~')
    replacements = args.replacements.split('~')

    if len(keywords) != len(replacements):
        raise ValueError("The number of keywords and replacements must be the same.")

    keyword_pairs = list(zip(keywords, replacements))

    if os.path.isfile(args.path):
        replace_in_file(args.path, keyword_pairs, args.log)
    elif os.path.isdir(args.path):
        replace_in_directory(args.path, keyword_pairs, args.log)
    else:
        raise ValueError("The specified path is neither a file nor a directory.")

if __name__ == "__main__":
    main()