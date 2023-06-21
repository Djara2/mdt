# mdscv Documentation

**Author:** David Jara

**Date:** June 21st, 2023

**mdcsv** is a program that converts a table in Markdown to a CSV file, and vice versa. Switching between the two conversion modes is as simple as changing which file type comes first. This is will be expanded upon in the following sections of this document.

# Turning Markdown into a CSV File

**The Key:** Simply just make sure that the source Markdown file is the 1st positional argument. 

**Example:** If you have a file called _table.md_ and you want to create a file called _table.csv_ then you would use the program as follows:
```powershell
mdcsv table.md table.csv
```
# Turning a CSV into a Markdown Table

**The Key:** Simply just make sure that the source CSV file is the 1st positional argument. 

**Example:** If you have a file called _table.csv_ and you want to create a file called _table.md_ then you would use the program as follows:
```powershell
mdcsv table.csv table.md
```
# Redirection (Do Not Create a File)

This program uses Unix-style command line arguments. If you add `-p`, `--print`, `-r`, or `--redirect`, then the program will not create a file, and instead print to stdout, meaning that you can redirect the output as you wish.

**Example:** copying the output to the clipboard on Windows, instead of creating a file
```powershell
# all of these commands have the same output
mdcsv table.md -p | clip
mdcsv table.md --print | clip
mdcsv table.md -r | clip
mdcsv table.md --redirect | clip
```
