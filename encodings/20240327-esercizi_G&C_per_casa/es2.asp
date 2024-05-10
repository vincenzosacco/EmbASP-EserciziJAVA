%Esercizio 2
%Si prenda in considerazione il gioco giapponese chiamato “FUTOSHIKI”. 
%In questo gioco matematico si deve riempire una griglia quadrata contenente NxN celle, 
%di modo che ogni riga o colonna contenga tutti e soli i numeri da 1 a N. 
%Sono inoltre presenti vincoli tra alcune celle adiacenti,
% espressi con un segno di maggiore (o minore, a seconda del punto di vista), 
%che devono ovviamente essere rispettati: 
%se tra due celle adiacenti è presente la diseguaglianza, i numeri collocati 
%dovranno rispettarne il verso. 
%Nella griglia di input possono essere già presenti alcuni numeri che aiutano la risoluzione. 
%Si scriva un programma logico ASP che consenta ad un sistema (come ad esempio DLV) 
%di risolvere il rompicapo

%di seguito sono riportati i fatti e le regole che descrivono due input diversi. Testare il programma su entrambi gli input

%input1
riga(1..4).
colonna(1..4).

maggiore(2,3,2,4). %la cella 2,3 deve contenere un valore maggiore di quello in 2,4.
maggiore(4,2,3,2). %la cella 4,2 deve contenere un valore maggiore di quello in 3,2.

cella(X,Y) :- riga(X), colonna(Y).
riempi(1,2,3). %la cella 1,2 contiene già un 3.
riempi(1,3,2). %la cella 1,3 contiene già un 2.
riempi(2,1,2). %la cella 2,1 contiene già un 2.
riempi(2,2,4). %la cella 2,2 contiene già un 4.

%svolgimento 

%GUESS
riempi(X,Y,N) | scarta(X,Y,N) :- cella(X,Y), numero(N).

%AUX RULES
numero(N):- riga(N).
piena(X,Y):- riempi(X,Y,_).

%CHECK
% se un cella esiste, deve essere riempita 
:- cella(X,Y), not piena(X,Y).

% un numero può essere presente 1 sola vola in una riga 
:- riempi(X1,Y,N), riempi(X2,Y,N), X1!=X2.
% un numero può essere presente 1 sola volta in una colonna  
:- riempi(X,Y1,N), riempi(X,Y2,N), Y1!=Y2.

% vincoli di maggioranza
:- maggiore(X1,Y1,X2,Y2), riempi(X1,Y1,N1), riempi(X2,Y2,N2), N1<N2.


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%input 2
% riga(1..5).
% colonna(1..5).

% cella(X,Y) :-riga(X), colonna(Y).

% maggiore(1,4,1,5).
% maggiore(1,3,2,3).
% maggiore(2,4,2,3).
% maggiore(3,2,2,2).
% maggiore(2,3,3,3).
% maggiore(3,4,2,4).
% maggiore(4,1,4,2).
% maggiore(4,5,4,4).
% maggiore(5,2,5,3).
% maggiore(5,3,4,3).
% maggiore(4,4,5,4).

#show riempi/3.
#show maggiore/4.
#show cella/2.
