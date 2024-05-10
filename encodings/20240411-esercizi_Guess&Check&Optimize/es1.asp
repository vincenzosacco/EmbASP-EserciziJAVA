% Esercizio 1. Dato un grafo G = <N, A>, diciamo che G ha una cricca di dimensione k se c'è un insieme di k 
% nodi  tale  che  ogni  coppia  di  nodi  al  suo  interno  è  connessa  da  un  arco.  Scrivere  un  programma  ASP 
% che calcoli tutte le cricche di dimensione data (tramite un fatto "clique(k)" -  Esempio: "clique(3).) di un dato 
% grafo, rappresentato tramite la relazione binaria arc(Nodo1, Nodo2)

%--FACTS
% clique(X).
% arc(Node1,Node2).

% arc(1,2). 
% arc(2,3). 
% arc(3,4). 
% arc(1,5). 
% arc(3,5). 
% arc(2,5).

% clique(3).


#show inClique/1.

%GUESS
inClique(X) | outClique(X) :- node(X), arc(X,_).

%AUX
node(X) :- arc(X,_).
% un nodo X non è connesso con un nodo Y nella cricca se non esiste un arco (X,Y) 
notConnected(X):- node(X), inClique(Y), not arc(X,Y), X<>Y. 

% Grafo Non Orientato
arc(X,Y):- arc(Y,X).


%CHECK
:- inClique(X), notConnected(X). 
:- clique(N), not #count{X : inClique(X)} = N.

