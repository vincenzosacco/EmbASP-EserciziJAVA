% Given a directed graph and a starting node, find a path beginning at the
% starting node which contains all nodes of the graph.

#show inPath/2.

node(1). node(2). node(3).
arc(1,2). arc(2,3). arc(3,4). arc(4,1). arc(3,1).
start(3).

%GUESS
inPath(X,Y) | outPath(X,Y) :- arc(X,Y).
%AUX
reached(X):- start(X). 
reached(X) :- reached(Y), inPath(Y,X). 


%CHECK
:- inPath(X,Y), inPath(X,Y1), Y != Y1. 
:- inPath(X,Y), inPath(X1,Y), X != X1. 

:- node(X), not reached(X). % ogni nodo deve essere reached
:- inPath(X,Y), start(Y). % a path, not a cycle, non può esistere un arco in cui start è la destinazione