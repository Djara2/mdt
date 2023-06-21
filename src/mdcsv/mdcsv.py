from sys import argv

def table_to_csv_str(table: str) -> str:
    # each element is now a record. First element is the headers
    split_table = table.split("\n")
    list_table = [record.split("|") for record in split_table]
    list_table = [list(filter(lambda x : x != "", element))
                  for element in list_table]
    
    headers = list_table[0]
    # start from 2, because list_table[1] will always be just ['-']
    records = list_table[2:]

    csv_representation = ",".join(headers)
    for record in records:
        csv_representation += "\n"
        csv_representation += ",".join(record)
    return(csv_representation)

def csv_to_table_str(csv: list) -> str:
    csv = [line.replace("\n", "").replace(",", "|") for line in csv]
    headers: str = "| " + "".join(csv[0]) + " |"
    records: list = csv[1:]
    table: str = f"{headers}\n| - |\n"
    for record in records:
        table+= f"|{record}|\n"
    table = table[:len(table)-1]
    return(table)

if len(argv) < 3:
    exit()

ARGUMENTS = ["-p", "--print", "-r", "--redirect"]

source_file_name = argv[1]

destination_file_name = argv[2] if not argv[2] in ARGUMENTS else None

if ".md" in source_file_name:
    table_handle = open(source_file_name, "r")
    table: str = table_handle.read()
    table_handle.close()

    csv_table: str = table_to_csv_str(table)
    
    if destination_file_name != None:
        csv_file_handle = open(destination_file_name, "w")
        csv_file_handle.write(csv_table)
        csv_file_handle.close()
        print(f"Successfully wrote table to {destination_file_name}!")
    else:
        print(csv_table)

elif ".csv" in source_file_name:
    csv_file_handle = open(source_file_name, "r")
    csv: list = csv_file_handle.readlines()
    csv_file_handle.close()
    
    table: str = csv_to_table_str(csv)

    if destination_file_name != None:
        table_file_handle = open(destination_file_name, "w")
        table_file_handle.write(table)
        table_file_handle.close()
        print(f"Successfully wrote csv to {destination_file_name}!")
    else:
        print(table)

else:
    print("[Input Error] The input file (positional argument 1) must be either a .md or .csv file.")
