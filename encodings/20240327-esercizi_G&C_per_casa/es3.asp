
% Esercizio 3.
% Quattro amici, nonostante generalmente vadano molto d’accordo, hanno gusti 
% completamente diversi riguardo i programmi televisivi preferiti. Infatti, 
% ognuno di loro ha come suo programma preferito un programma diverso da 
% quello degli altri tre amici. Inoltre tali programmi vengono tutti 
% trasmessi in giorni ed orari tra loro differenti.  Scrivere un programma
% DLV che, utilizzando gli indizi seguenti, individui per ogni amico: il titolo 
% del suo programma preferito, il giorno della settimana e l’orario in cui
% viene trasmesso.

% Indizi:

% 1.	La serie “CSI” non viene trasmessa di domenica.
% 2.	Il programma “Ulisse”, trasmesso alle 7 di sera, non è quello preferito da Michele.
% 3.	“Stranamore” non è il programma preferito di Alberto.
% 4.	Il programma preferito di Roberto viene trasmesso alle 10 di sera ma non di mercoledì.
% 5.	Il programma trasmesso martedì sera è “XFactor”.
% 6.	Michele non guarda mai la televisione alle 9 di sera, mentre Giorgio non la guarda mai di domenica.
% 7.	“Stranamore” viene trasmesso un’ora dopo rispetto all’orario di inizio del programma preferito di Giorgio, 
%       ma un’ora prima rispetto al programma trasmesso di lunedì.

% Amici:     		Alberto, Giorgio, Michele, Roberto
% Programmi : 	CSI, Stranamore, Ulisse, XFactor
% Giorni:     		domenica, lunedì, martedì, mercoledì
% Orari inizio:    	7, 8, 9, 10 (PM).

% amico(A)
amico(alberto).
amico(giorgio).
amico(michele).
amico(roberto).

% programma(P)
programma(csi).
programma(stranamore).
programma(ulisse).
programma(xfactor).

% giorno(G)
giorno(domenica).
giorno(lunedi).
giorno(martedi).
giorno(mercoledi).

% orario(O)
orario(7).
orario(8).
orario(9).
orario(10).



%GUESS
in(A,P,G,O) | out(A,P,G,O) :- amico(A), programma(P), giorno(G), orario(O).
%in(A,P,G,O):- amico(A), programma(P), giorno(G), orario(O), not amicoIn(A). 
%CHECK
amicoIn(A):- in(A,P,G,O).



%CHECK
% ogni amico deve avere un solo programma assegnato a un certo orario
:- amico(A) ,  not amicoIn(A).
:- amicoIn(A), #count{A,P,G,O: in(A,P,G,O)} >=2.

% non esistono programmi che vanno in onda alla stessa ora nello stesso giorno
:- in(_,P1,G,O), in(_,P2,G,O), P1<>P2.


% ognuno di loro ha come suo programma preferito un programma diverso da quello degli altri tre amici. 
:- in(A1,P,_,_), in(A2,P,_,_), A1<>A2.


% 1. La serie “CSI” non viene trasmessa di domenica.
:- in(_,csi,domenica,_).

% 2. Il programma “Ulisse”, trasmesso alle 7 di sera, non è quello preferito da Michele.
:- in(michele,ulisse,_,7).

% 3. “Stranamore” non è il programma preferito di Alberto.
:- in(alberto,stranamore,G,O).

% 4. Il programma preferito di Roberto viene trasmesso alle 10 di sera ma non di mercoledì.
:- in(roberto,_,_,10).
:- in(roberto,_,mercoledi,_).

% 5. Il programma trasmesso martedì sera è “XFactor”.
:- in(_,P,martedi,_), P <> xfactor.

% 6. Michele non guarda mai la televisione alle 9 di sera, mentre Giorgio non la guarda mai di domenica.
:- in(michele,P,G,9).
:- in(giorgio,P,domenica,O).

% 7. “Stranamore” viene trasmesso un’ora dopo rispetto all’orario di inizio del programma preferito di Giorgio, 
%     ma un’ora prima rispetto al programma trasmesso di lunedì.
:- in(_,stranamore,_,O1), in(giorgio,_,_,O2),  O1 <> O2+1.
:- in(_,stranamore,_,O1), in(_,_,lunedi,O2),  O1 <> O2-1.




