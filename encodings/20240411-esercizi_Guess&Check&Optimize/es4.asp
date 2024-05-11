% Esercizio 4. 
% Sia G=<V,E> un grafo orientato definito tramite i predicati (fatti) 
% edge(Vertex1,Vertex2,Color), e vertex(N,Color), in cui gli archi e i nodi sono colorati con 3 colori 
% differenti (rosso, verde, blu). Stabilire se esiste un sottoinsieme SDIV di V avente  le seguenti proprietà:  
% 1. SDIV è non vuoto. 
% 2. presi due qualunque nodi v1 e v2 in SDIV, e dati i loro colori C1 e C2, nessun arco che li connette 
% può essere di colore C1 o C2. 
% 3. la cardinalità (numero di nodi) di SDIV è massima. 

%FACTS
% edge(Vertex1,Vertex2,Color)
% vertex(N,Color)
color(red). color(green). color(blue).

% edge(2,3,r).
% edge(1,2,r). 
% edge(1,3,b). 
% edge(1,4,g). 
% vertex(1,b). 
% vertex(2,g). 
% vertex(3,r). 
% vertex(4,b).


#show vertexIn/1.

%GUESS
vertexIn(N) | vertexOut(N) :- vertex(N,C).

%AUX


%CHECK
% 1. SDIV è non vuoto. ---> Assumo che ci siano i fatti necessari per poter costruire un insieme SDIV non vuoto.
% :- #count{N,C : vertexIn(N,C)} = 0.
almenoUno:- vertexIn(N). 
:- not almenoUno.

% 2. presi due qualunque nodi v1 e v2 in SDIV, e dati i loro colori C1 e C2, nessun arco che li connette 
% può essere di colore C1 o C2. 
:- vertexIn(N1), vertexIn(N2), edge(N1,N2,C), vertex(N1,C). 
:- vertexIn(N1), vertexIn(N2), edge(N1,N2,C), vertex(N2,C). 

 
% 3. la cardinalità (numero di nodi) di SDIV è massima. 
:~ vertexOut(N). [1@1, N]
