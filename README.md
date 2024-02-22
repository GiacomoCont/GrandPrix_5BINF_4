# GrandPrix 5Binf 4
Simulazione di gare automobilistiche

[![release](https://img.shields.io/badge/versione-1.0-green.svg?style=round-square)]()
[![contributors](https://img.shields.io/badge/contributori-4-blue)]()
[![License: GPL v3](https://img.shields.io/badge/Licenza-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

-----------
- Proprietario del repository: Contini.
- Collaboratori: Borzuola, Gropasi, Miscia.

Descrizione Progetto
--------
Questo progetto è stato creato per simulare una gara di corse automobilistiche, con un login e credenziali salvate.<br /> Le principali tecnologie per creare e sviluppare questo progetto sono state i `threads` per riuscire a gestire le varie sezioni dell'applicazione ad esempio, la classe Auto.java è un thread in modo da riuscire a gestire più auto nella gara in modo organizzato e risparmiando risorse.<br /> Per quanto riguarda il login abbiamo usato `BufferedWriter` ovvero uno `Stream` sia per la lettura che scrittura dei file e delle credenziali varie dei giocatori.

Istruzioni all'uso 
------------------
- Come prima cosa useremo la classe `Giudice.java` per l'avvio, in quanto classe contenente il main, fatto questo ci dirigiamo allo step successivo.
- Avviata la classe giudice ci apparirà un'interfaccia dove l'utente può inserire _username_ e *password* (cifrati grazie alla classe `Vigenere.java`), salvate in file "user.csv".
- Come seconda opzione l'utente può inserire le informazioni delle auto e dei piloti, scegliendo prima il numero dei due, o se non si desidera immettere manualmente le informazioni delle altre auto sarannò impostate di default. I dati delle auto e dei piloti verrano salvati in un file "auto&piloti.bin".
- La terza consiste nella creazione del _Circuito_ scegliendo nome, lunghezza, numero di giri e pit-stop.
- Nella quarta sezione del menù si può decidere di truccare la propria auto cambiando la sua velocità (Attenzione darà errore se la velocità dell'auto sarà maggiore della metà della lunghezza del circuito!! es. velocità auto 8 ma con 10 di lunghezza darà errore se invece di 8 inseriremo 4 il programma continuerà il suo normale funzionamento).
- Infine abbiamo *Avvia gara* dove verranno mostrati a schermo dei punti che rappresenteranno le auto in gara, i pit stop verranno generati casualmente per ogni auto i quali avranno la durata di circa 1.5 secondi di stop. Alla fine della gara verrà visualizzata una classifica che verrà salvata nel file "classifica.txt".

Riferimenti 
-----------
Per struttura e spunti per questo README.md è stato usato il sito ["Come Scrivere un buon README"](https://www.freecodecamp.org/italian/news/come-scrivere-un-buon-file-readme-per-i-tuoi-progetti-github/)

Licenze
-------
Copyright © 2024 [Giacomo Contini](https://github.com/GiacomoCont), [Francesco Borzuola](https://github.com/Francyborzi), [Matteo Gropasi](https://github.com/matteogropasi) & [Franco Miscia](https://github.com/FrankMisciaj).<br />
Questo Prodotto è sotto licenza [GNU-GPLv3](https://www.gnu.org/licenses/gpl-3.0).

