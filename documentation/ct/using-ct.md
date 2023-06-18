# ct Documentation

**Author:** David Jara

**Date:** June 18th, 2023

# What is ct?

**ct** is short for "color tag." Why is this? This is the name of the program, because you give it a color followed by whatever text you want, and it copies to your clipboard said text, enclosed in HTML span tags with an inline style definition corresponding to whatever color you provided it.

**Okay, that's great, but why exactly does it do that?** Markdown provides no way to add color to your text, unless you use HTML. This program saves all the extra strokes (and expectation that you memorize the hex codes for colors) of writing HTML span tags by hand. For example, to get orange text copied directly to your clipboard, ready for you to paste into whatever program you use to write Markdown, you can just enter `ct orange This text will be orange` into your terminal, instead of manually writing out \<span style = "color: #ff7f24">This text will be orange\</span>. 

**So, how does that save you from having to memorize hex color codes exactly?** You may have noticed all I entered in the above example was "orange," yet I got a very specific kind of orange back in the HTML that ct generated. This is because the program utilizes a file called colordictionary.txt, which you can edit. This maps aliases to specific hex codes, so all you have to do is write the alias.

**Can ct apply color to the background as well?** Yes! The above example showed how you can use ct to change the foreground of text, but you can also use it to change the background. To do this, all you have to do is put "bg" at the end of the alias you defined. For example, if I instead wanted an orange background in that previous example, I would write `ct orangebg This text will be orange`. 

# Example Usage

The general syntax for the program is `ct color text`. The `color` argument is, of course, whatever color you want to apply. The `text` argument can either be a string like \"this is some text\", or it can be several words that are not enclosed in quotation mark, for example `ct orange "this is some text"` and `ct orange this is some text` have the same output.
