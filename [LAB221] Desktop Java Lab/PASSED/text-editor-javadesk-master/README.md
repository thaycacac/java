# My Text Editor (MTE)

_For TuanVM_

##### Background

A text editor is a type of program used for editing plain text files. Text editors are provided with operating systems and software development packages, and can be used to change configuration files, documentation files and programming language source code. Sometimes it is used to remove the formatting of a chunk of text that copied from a web page or other rich text editors. In Windows operating system, Notepad program is a text editor. Text editor is familiar with every programmer; it is a very important part of any IDE (Integrated Development Environment). In IDE, it is used to write source code.

##### Program Specifications

My Text Editor (MTE) is a common text-only (plain text) editor. The resulting files—typically saved with the .txt extension—have no format tags or styles, making the program suitable for editing system files and, and occasionally, source code for later compilation or execution. It is also useful for its negligible use of system resources; making for quick load time and processing time, especially on under-powered hardware. For simplification, MTE is a single document interface (SDI) with a menu and a large text area to typing. It allows user to save the content in ASCII or Unicode code with maximum 16Kb in size.

|No|Name|Short description|Group in menu item|
|--|----|---------------|-----------------|
|1|New|Create an empty document|File|
|2|Open|Open an existing file|File|
|3|Save|Save the content to a text file|File|
|4|Save as|Save the opened file to a new file|File|
|5|Exit|Close the MTE|File|
|6|Sellect all|Select all text|Edit|
|7|Cut|Delete the selected text and put it in the OS clipboard|Edit|
|8|Copy|Copy the selected text and put it in the OS clipboard|Edit|
|9|Paste|Paste the text stored in clipboard into the current position|Edit|
|10|Undo|Discard the last typing (type, cut, copy, paste) action|Edit|
|11|Redo|Redo last typing (type, cut, copy, paste) action that the user has discarded|Edit|
|12|Find|Find a text in the document|Edit|
|13|Replace|Replace a text with another one|Edit|
|14|Change font|Change the font of the editor (text typing area) | Edit|

##### Guidelines
The following components should be used: JOptionPane, JTextArea, JFrame, JMenuBar, JFileChooser, JFontChooser
##### Expectation of User interface:
The user interfaces should be simple, familiar with normal user and it should look like: 
![image interface](https://github.com/Sharp-Team/text-editor-javadesk-master/blob/master/interface.png)
