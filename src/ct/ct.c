#include<stdlib.h>
#include<stdio.h>
#include<string.h>
int main(int argc, char* argv[])
{
	char path[1024] = "..\\src\\ct ct";
	char cmd[1024] = "java -classpath ";
	strcat(cmd, path);
	for(int i = 0; i < argc; i++)
	{
		strcat(cmd, " ");
		strcat(cmd, argv[i]);
	}
	system(cmd);
}
