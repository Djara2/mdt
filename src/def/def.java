public class def
{
	public static void main(String[] argv)
	{
		String term = "**++" + argv[1];
		for(int i = 2; i < argv.length; i++)
		{
			term = term + " " + argv[i];
		}
		term = term + "++**\n: ";
		simpleclip.copy(term);
	}
}
