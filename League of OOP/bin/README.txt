POLITIC ANDREI-BOGDAN, GRUPA 325CD
POO, TEMA1

			-- DESCRIEREA IMPLEMENTARII ALGORITMULUI --


	Am decis sa impart proiectul astfel :
		-un pachet "main" cu toate clasele ce se refera la aspecte esentiale ale jocului (in general etape ale jocului):
			cea de culegere a datelor necesare derularii (input-ul din fisier), cea de initializare a hartii cu pozitiile 
			jucatorilor, cea de initializare a jucatorilor impreuna cu caracteristicile lor, cea de desfasurare a luptelor,
			si cea de expunere a rezultatelor (output-ul);
		-un pachet "gameplay" care detine in special clase legate de aspecte particulare ale jucatorilor, precum viata lor, damage-ul
			pe care il dau, abilitatile overtime pe care le sufera, experienta, si level-ul;
		-cate un pachet pentru fiecare jucator, ce detine ceea ce are in particular fiecare tip de erou: viata si cele doua
			abilitati.

	Jocul incepe cu citirea input-ului din primul fisier dat ca parametru in main. Pentru harta am utilizat o matrice, pentru pozitiile
initiale  ale jucatorilor am folosit un vector de lungime egala cu jumarul de jucatori, iar pentru deplasarile de pe harta am folosit o 
matrice cu numarul liniilor egal cu numarul rundelor, si cu numarul coloanelor egal cu numarul de jucatori.
	Am organizat harta in celule, fiecare celula devenind un obiect ce retine doua "adrese" (indecsi) ale jucatorilor ce se dueleaza 
"in" celula, si de asemenea tipul de teren si runda curenta. Un jucator este descris de o clasa cu aspecte generale (Player), iar aspectele
particulare sunt retinute in clasele Pyromancer, Knight, Wizard, sau Rogue, dupa caz, iar aceste clase mostenesc clasa Player.
Pentru a retine jucatorii, am realizat un vector ce ii retine in ordinea in care au fost declarati in input pe pozitiile initiale. Acestia
vor ramane in aceasta ordine pana la final, in vector. Atunci cand un jucator moare, exista un camp in clasa lui generala (Player) care
specifica faptul ca a cedat din viata.
	Se incepe cu initializarea vectorului cu jucatori si cu initializarea hartii (in aceeasi clasa cu initializarea, se va face si 
update la harta la inceputul urmatoarelor runde). In caz ca niciun jucator nu se afla pe o anumita patratica (celula) de pe harta, ambele 
spatii se vor completa cu valoarea -1. In caz ca se afla doar un jucator, celula va fi atribuita cu valoarea indexului din vector al
jucatorului, iar cealalta jumatate ramane completata cu valoarea -1. In caz ca intr-o celula se afla doi playeri, ambele campuri vor fi 
initializate, fiecare cu indexul unuia dintre cei doi jucatori (daca jucatorul este mort in acel moment, partea de celula in care ar fi
trebuit sa se afle este tot -1).
	Intr-o instructiune "for" din main, se vor itera toate rundele. Intai se actualizeaza bucata de informatie initial primita din input,
apoi harta, cu noile pozitii ale jucatorilor, apoi vectorul de jucatori, care urmeaza sa primeasca statutul final (de la finele rundei)
al jucatorilor. Aceasta initializare din urma dureaza cel mai mult, si practic descrie toata lupta din runda respectiva. Mai intai se intra
intr-o clasa Fight, unde se parcurge toata matricea hartii, si se cauta perechile valide de combatanti in fiecare celula. Daca se gaseste,
incepe lupta corp-la-corp, iar daca nu, pentru jucatorii care nu au adversar in acel moment, runda va insemna doar miscarea acestora (deja
efectuata) pe harta, si eventual consumarea pe ei a efectului overtime, daca sunt afectati.
	Lupta corp la corp se "desfasoara" in clasa FightingHeroes, unde nu ajung decat jucatorii care au adversari de lupta. Mai intai, li
se calculeaza efectul overtime din punct de vedere al vietii (in cazul in care efectul cere, viata li se scade corespunzator. !Important!
- efectul care da incapacitate de miscare player-ilor este analizat inainte, si decide daca jucatorul se poate misca sau nu runda respectiva.)
Numai daca ambii jucatori raman vii dupa eventualul efect de overtime, doar atunci va avea loc lupta.
	Toate clasele ce desemneaza abilitati ale jucatorilor au doua campuri primite ca parametru (la campul jucatorului si campul
adversarului ), mai putin clasa WizardDeflect (abilitatea de deflect a Wizard-ului) care are 3 campuri (cele doua, plus un camp care
primeste damage-ul facut de adversar - necesar calcularii damage-ului abiliatii deflect a Wizard-ului). Tocmai de aceea, in clasa
FightingHeroes, in momentul inceperii luptei corp-la-corp, exista 2 x 2 = 4 cazuri (toate situatiile posibile in care in prima celula se
afla / nu se afla un Wizard, iar in a doua se afla / nu se afla un Wizard ).
	In cazul in care printre ei se afla un Wizard (doua din cele patru variante), se calculeaza damage-ul dat de jucator neluand in
seama modificatorii de rasa (race modifiers), necesar pentru calcularea damage-ului facut de abilitatea deflect a Wizard-ului. In toate cele
patru cazuri, se calculeaza damage-ul dat de fiecare jucator asupra celuilalt, si se retine in variabile. Dupa lupta, ambele variabile scad
vice-versa vietile jucatorilor cu valoarea lor. Dupa lupta, fiecare jucator primeste eventual un efect de overtime (care depinde de jucatorul
cu care s-a duelat in acea runda). Acest efect overtime suprascrie dupa lupta efectul overtime precedent (in cazul in care exista).
	Dupa stabilirea acestor statistici, urmeaza stabilirea experientei si a level-ului jucatorilor, evident, numai jucatorilor care isi
omoara adversarul. Deoarece abilitatile overtime urmeaza sa se consume pe adversari abia la inceputul rundei viitoare, in runda curenta nu
vor muri, oricat de mica ar avea viata, din cauza primirii unui DoT (Damage Overtime) mai mare decat viata. Asadar, dar se intampla ca
adversarul sa moara runda urmatoare, jucatorul nu mai primeste experienta de pe omorarea lui.
	Tot in aceasta functie in care se desfasoara lupta, se mai modifica si anumiti parametri ai jucatorilor, statutul de vii/morti,
runda curenta (este retinuta de jucator deoarece ajuta la unele abilitati, precum rundele de overtime ramase), si numarul de atacuri
 (necesar pentru ca Rogue sa isi poata multiplica cu 1.5 puterea de la Backstab, o data la 3 runde). In final, functia returneaza vectorul
cu jucatorii, asupra caruia au avut loc toate operatiile din "interiorul" luptei. Astfel, vectorul este proaspat update-at pentru runda
 urmatoare.
	Dupa rularea rundelor, la final se preiau statisticile din obiectul de input (care de asemenea a fost update-at la inceputul fiecarei
runde) si din vectorul de playeri, si se transmit in fisierul de output, in forma ceruta.