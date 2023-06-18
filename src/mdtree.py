from utils import io_utils

def display_preview(filename: str, levels: list, titles: list) -> None:
    representation = f"{filename}\n{'-' * len(filename)}\n"
    counter = 1
    counter_str = str(counter)
    max_counter_len = len(str(len(levels)))
    for level, title in zip(levels, titles):
        counter_difference = max_counter_len - len(counter_str)
        leading_zeros = "0" * counter_difference
        indentation = "..." * (level - 1)
        representation += f"{leading_zeros}{counter} {indentation}{title}\n"
        counter += 1
        counter_str = str(counter)
    print(representation)

files = io_utils.get_markdown_files()
for file in files:
    levels, titles = io_utils.get_headers(file)
    display_preview(file, levels, titles)
