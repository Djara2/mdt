from os import listdir, getcwd
from collections.abc import Sequence

def get_markdown_files(path: str = None) -> list:
    if path == None:
        path = getcwd()
    files = [file for file in listdir() if ".md" in file]
    return(files)

def get_headers(file: str) -> tuple[list]:
    file_handle = open(file, "r")
    contents = file_handle.readlines()
    file_handle.close()
    candidates = [line.split() for line in contents if "#" in line]
    headers = [header for header in candidates if "#" in header[0]]
    levels = [header[0].count("#") for header in headers]
    titles = [" ".join(header[1:]) for header in headers]
    return(levels, titles)
