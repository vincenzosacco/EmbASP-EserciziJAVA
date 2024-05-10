% a(X,Z):- b(X,Z,Y), not c(Z).
% c(X):- d(X,Y), not a(X,X).
% b(X,Y,Z):- d(X,Y), d(Y,Z). 
% c(Y)| f(X,Y):- a(Y,X).
% :- b(X,Y,Z), c(X).

% d(1,1). d(2,1).

% parigi(X) | londra(X):- ferie(X),  not malato(X).
% malato(X):- ferie(X), not parigi(X).
% ferie(X):- periodo(X,Y), malato(Y).

% malato(1). ferie(3). periodo(2,3). periodo(4,2). parigi(4).