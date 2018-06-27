# Designing a Logical Processing Unit

In this project, we will design a logical characters processing unit. The processing unit will receive a series of characters as input and produce a series of characters as output. The unit may house any number of processing blocks. Not all blocks that are available may be used when creating a processing unit. Also, a block may be used more than once. The order in which the blocks are used may also vary.
                                                            
...input... -> | block1 block2 block3 ... | -> ...output...

Let's discuss some examples of blocks and then revisit the processing unit.

1. __UpperCaseConverter__ Block
	Given a character, this block will send out or return the character in uppercase.

2. __LowerCaseConverter__ Block
	Given a character, this block will send out or return the character in lowercase.
	
3. __Multiplier__ Block
  Given a character, this block will send out or return two of the same character. For example, if it received 'a', it will produce 'aa'. If it receives '1', it will produce '11'.

4. __z-blocker__ Block
  Given a character, if the character is a lowercase 'z', this block will not return or produce anything. If it is any other character, it will produce the given character as output. For example, 'a' will result in an output of 'a'.

5. __Z-blocker__ Block
	This block will not return or produce an output if the character given is an uppercase 'Z'.
	
6. __k-blocker__ Block
   This block will not return or produce an output if the character given is lowercase 'k'.

The program should allow end users to create other similar blocks they like.

The end user should be able to create a processing unit using a series of blocks.

For example, a user may create a processing unit with the following series of blocks:

	UpperCaseConverter - Z-blocker - LowerCaseConverter
	
After creating this processing unit, if a user were to send the following series of characters to the unit:

	11abcdabcdabcdzzaazzabcd

it will return the following output:

	11abcdabcdabcdaaabcd

In addition to designing a few sample blocks and the processing unit, we will create a console based driver program.
	
Design the program in such a way that:

1. A user can specify the blocks available for use before the program starts. This should include pre-defined blocks and user created blocks.

2. The user can specify, through a file, the blocks they'd like to use and the order or sequence in which they'd like to use them.

Think through the overall design of the program first. Then start with one small, but interesting and valuable part, and evolve the design and code incrementally.
