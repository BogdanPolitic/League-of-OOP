# League-of-OOP
	=============

	Problem description: Imagine a MOBA game, with 2 or more heroes placed on a map represented by a matrix. They have a specific moving each time, and each time 2 heroes are on the same map cell, they fight (one round). They can either die (both), either one lives and one dies, or they both survive. The final score lists the players, their status, and their final positions on the map.
	The heroes can be of 4 types: knight (K), pyromancer (P), rogue (R), wizard (W). Each of them has two abilities, each one is different from each ones the other hero types have. They also level up, depending on killing or damaging the enemy. The start level is 0.

	The executable should be run with 2 parameters: the first is the input file, the second is the output file.
	The input file structure is the following:
		-> the first line specifies the number of lines (L) and number of columns of the matrix representation of the battlefield.
		-> the following L lines are representing the map: each hero in his initial position.
		-> the following line contains one integer: the number of heroes (H).
		-> the following H lines specify each hero on the battlefield, in this format (his type (K / P / R / W), his X position on the map, his Y position on the map). Let's call this the 'hero presentation'.
		-> the following line contains one integer: the number of rounds (R).
		-> the following R lines contain the directions that each player are moving towards, after finishing the current round. In this representation, a hero is associated with 1 specific column, in the same order the heroes were specified in the 'hero presentation'.

	Each ability has an exact formula of the attack dealt on the enemy, whether his power freezes the enemy or not, the amount of life given or taken, and other particularities. All the formulas, including the leveling up rules, are presented in the source files.

	The output files has H lines. In the exact order from the hero presentation, on each line, one hero is represented along with his final status: his hero type, his level, his attack, his life, his position X on the map, his position Y on the map, in this exact order. If the hero is dead, neither of the last 5 stats are displayed; instead, the 'dead' status is specified.
