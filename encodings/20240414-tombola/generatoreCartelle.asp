% Si progetti e si implementi una applicazione Java (o Python, o C#) 
% per generare cartelle per la tombola napoletana. 
% In particolare, l'applicazione dovrà chiedere all'utente quante cartelle desidera, 
% generarle e visualizzarle su standard output. 
% Se il numero di cartelle generabili fosse minore del numero specificato dall'utente,
% visualizzare su standard output tutte le cartelle generabili.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Per la generazione delle cartelle si utilizzi un programma ASP
%  e si tenga conto quanto descritto di seguito; ogni cartella:  
%  - deve contenere esattamente 15 numeri compresi tra 1 e 90;
%  - i numeri devono essere distribuiti su 3 file e 9 colonne;
%  - ciascuna colonna deve contenere almeno 1 numero, e non piu' di 2;
%  - ciascuna riga deve contenere esattamente 5 numeri;
%  - la prima colonna puo' contenere solo numeri  tra 1 e 9; 
%     la seconda colonna numeri tra 10 e 19; la terza tra 20 e 29, 
%     e cosi' via fino all'ottava, che contiene i numeri tra 70 e 79; 
%     la nona colonna puo' contenere numeri tra 80 e 90;
%  - in aggiunta, rispetto alle regole classiche, 
%     è preferibile evitare cartelle che contengano numeri consecutivi nella stessa colonna.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Si faccia uso del framework EmbASP per invocare il sistema DLV2 sul programma logico così ottenuto.
% Le opzioni -n N e --printonlyoptimum di DLV2 possono essere utilizzate per ottenere 
% da DLV2 N answer set ottimi (qualora esistano almeno N answer set ottimi).

#show  in/3.
numero(1..90).
riga(0..2).
col(0..8).

%GUESS
in(N,R,C) | out(N,R,C) :- numero(N), riga(R), col(C). 

%AUX
numeroIn(N):- in(N,R,C).


%CHECK
%  un numero può apparire una sola volta
:- numeroIn(N), #count{N,R,C : in(N,R,C)} <> 1.

% un cella contiene un solo numero 
:- in(_,R,C), #count{N : in(N,R,C)} <>1.


% ciascuna riga deve contenere esattamente 5 numeri;
:- riga(R) , #count{N: in(N,R,_)} <> 5.

% ciascuna colonna deve contenere almeno 1 numero, e non piu' di 2;
:- col(C), #count{N: in(N,_,C)} < 1.
:- col(C), #count{N: in(N,_,C)} > 2.


% la prima colonna puo' contenere solo numeri  tra 1 e 9; 
:- in(N,_,0), N>9.
% la seconda colonna numeri tra 10 e 19; 
:- in(N,_,1), N<10.
:- in(N,_,1), N>19.
% la terza tra 20 e 29, 
:- in(N,_,2), N<20.
:- in(N,_,2), N>29.
% e cosi' via fino all'ottava, che contiene i numeri tra 70 e 79; 
:- in(N,_,3), N<30.
:- in(N,_,3), N>39.

:- in(N,_,4), N<40.
:- in(N,_,4), N>49.

:- in(N,_,5), N<50.
:- in(N,_,5), N>59.

:- in(N,_,6), N<60.
:- in(N,_,6), N>69.

:- in(N,_,7), N<70.
:- in(N,_,7), N>79.
% la nona colonna puo' contenere numeri tra 80 e 90;
:- in(N,_,8), N<80.
:- in(N,_,8), N>90.

% è preferibile evitare cartelle che contengano numeri consecutivi nella stessa colonna.
:~ in(N1,_,C), in(N2,_,C), N2=N1+1. [2@1, C]
:~ in(N1,_,C), in(N2,_,C), N2=N1-1. [2@1, C]

% è preferibile evitare cartelle che contengano numeri consecutivi nella stessa riga.
:~ in(N1,R,_), in(N2,R,_), N2=N1+1. [1@1, R]
:~ in(N1,R,_), in(N2,R,_), N2=N1-1. [1@1, R]



