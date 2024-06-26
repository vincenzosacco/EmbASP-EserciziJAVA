% Esercizio 3. 
% Si consideri il seguente rompicapo. Obiettivo del gioco è completare una griglia di dimensione 4x4 
% con numeri che vanno da 1 a 9, rispettando le seguenti semplici regole:   
% 1) Ogni riga deve contenere numeri tutti diversi tra loro; 
% 2) Ogni colonna deve contenere numeri tutti diversi tra loro; 
% 3) La somma dei valori in una riga deve essere uguale al valore assegnato per quella riga; 
% 4) La somma dei valori in una colonna deve essere uguale al valore assegnato per quella colonna; 
% 5) La somma dei valori sulla diagonale principale deve essere uguale ad un valore assegnato; 
 
% Sono inoltre fornite le seguenti indicazioni: 
 
% 6) Nella prima riga è presente un 5; 
% 7) La terza riga e la terza colonna contengono valori disposti in ordine crescente; 
% 8) Il numero 3 compare esattamente una volta in tutta la griglia
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

#show cellaIn/3.

% FACTS
numero(1..9).
riga(0..3).
colonna(0..3).



% sommaRiga(K,R).
% sommaRiga(12).sommaRiga(14).sommaRiga(30).sommaRiga(17).
% % sommaColonna(K,C).
% sommaColonne(17).sommaColonne(15).sommaColonne(23).sommaColonne(18).
% % sommaDiagonale(K).
% sommaDiagonale(15).

% AUX
cella(R,C) :- riga(R), colonna(C).


% GUESS
cellaIn(N,R,C) | cellaOut(N,R,C) :- numero(N),cella(R,C).

% CHECK

% una cella è riempita una e una sola volta
:- cella(R,C), #count{N,R,C : cellaIn(N,R,C)}<>1.


% 1) Ogni riga deve contenere numeri tutti diversi tra loro
:- cellaIn(N,R,C1), cellaIn(N,R,C2), C1<>C2.

% 2) Ogni colonna deve contenere numeri tutti diversi tra loro
:- cellaIn(N,R1,C), cellaIn(N,R2,C), R1<>R2.

% 3) La somma dei valori in una riga deve essere uguale al valore assegnato per quella riga; 
:- sommaRiga(K,R), #sum{N: cellaIn(N,R,_)} <> K.

% 4) La somma dei valori in una colonna deve essere uguale al valore assegnato per quella colonna; 
:- sommaColonna(K,C), #sum{N : cellaIn(N,_,C)} <>K. 

% 5) La somma dei valori sulla diagonale principale deve essere uguale ad un valore assegnato; 
:- sommaDiagonale(K), #sum{N : cellaIn(N,I,I)} <> K.

% 6) Nella prima riga è presente un 5; 
:- #count{C : cellaIn(5,0,C)} <> 1.

% 7) La terza riga e la terza colonna contengono valori disposti in ordine crescente; 
% :- cellaIn(N,2,0), cellaIn(M,2,1), N>M.
% :- cellaIn(N,2,1), cellaIn(M,2,2), N>M.
% :- cellaIn(N,2,2), cellaIn(M,2,3), N>M.

% :- cellaIn(N,0,2), cellaIn(M,1,2), N>M.
% :- cellaIn(N,1,2), cellaIn(M,2,2), N>M.
% :- cellaIn(N,2,2), cellaIn(M,3,2), N>M.

% più elegante e generale di sopra
decrescente_riga(R,C1,C2) :- cellaIn(N,R,C1), cellaIn(M,R,C2), N>M, C2= C1+1.
decrescente_col(C,R1,R2) :- cellaIn(N,R1,C), cellaIn(M,R2,C), N>M, R2= R1+1.
:- decrescente_riga(2,C1,C2).
:- decrescente_col(2,C1,C2).



% 8) Il numero 3 compare esattamente una volta in tutta la griglia
:- #count{R,C: cellaIn(3,R,C), cella(R,C)} <> 1.



