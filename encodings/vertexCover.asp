% Given a graph, select a subset S of the vertices so that all edges are
% covered (i.e., every edge has at least one of the two vertices in S)
% Example:
% Consider the graph
% All the possible vertex covers are: {1}, {2,3}, and also {1,2},{1,3},{1,2,3}

#show inS/1.

node(1). node(2). node(3).
edge(1,2). edge(1,3).


% Guess - Generate all possible subset of nodes:
inS(X) | outS(X) :- node(X).


% This program has eight answer sets, encoding the eight plausible scenarios:
% AS1={inS(1), inS(2), inS(3)}  {1,2,3}
% AS2={inS(1), inS(2), outS(3)}  {1,2} AS3={inS(1), inS(3), outS(2)}  {1,3} AS4={inS(2), inS(3), outS(1)}  {2,3}
% AS5={inS(1), outS(2), outS(3)}  {1} AS6={outS(1), inS(2), outS(3)}  {2} AS7={outS(1), outS(2), inS(3)}  {3}
% AS8={outS(1), outS(2), outS(3)}

:- edge(X,Y), not inS(X), not inS(Y).

