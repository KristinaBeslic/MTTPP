# Testiranje [demo aplikacije](https://demo.opencart.com/)

Na ovom repozitoriju nalazi se projekt napravljen za kolegij Metode i tehnike testiranja programske podrške. U projektu je napravljeno testiranje demo aplikacije dostupne na [poveznici](https://demo.opencart.com/). 

### Korišteni alati
* [Katalon Recorder](https://chrome.google.com/webstore/detail/katalon-recorder-selenium/ljdobmomdgdljniojadhoplhkpialdid)
* [IntelliJ](https://www.jetbrains.com/idea/)
* [Java JDK](https://www.oracle.com/java/technologies/downloads/)
* [Chrome Driver](https://chromedriver.chromium.org/downloads)

#### Katalon Recorder
Katalon Recorder je alternativa za Selenium IDE. Open-source je alat koji je u ovom projektu korišten za snimanje UI testova. Testovi se spremani i izvezeni kao skripte u Java programskom jeziku. Katalon Recorder dostupan je kao dodatak u Chrome pregledniku ili kao desktop aplikacija, a u ovom projektu je korišten dodatak u Chrome pregledniku.

#### IntelliJ IDEA
IntelliJ IDEA je integrirano razvojno okruženje koje je u ovom projektu korišteno za testiranje demo aplikacije dostupne na [poveznici](https://demo.opencart.com/).
Testiranje je moguće tek nakon preuzimanja svih navedenih alata (IntelliJ, Java JDK i Chrome Driver-a).

### Testni slučajevi
U ovom projektu napravljeno je 5 testnih slučajeva koji se nalaze u [mapi](https://github.com/KristinaBeslic/MTTPP/tree/main/projekt/src/test/java/com/example/MTTPP):
* Register
* Login
* Add to cart
* Delete from cart
* Product comparison

Kako bi testovi izveli ispravno, testni slučaj za registriranje korisnika potrebno je izvršiti prvi ili drugi (drugi u slučaju ako se prvo izvršava testni slučaj za usporedbu proizvoda (_Product comparison_)). Testni slučaj za usporedbu proizvoda ne zahtijeva da korisnik bude registriran, zato ga je moguće izvesti i prije registracije korisnika. Kako bi testni slučaj za brisanje proizvoda iz košarice (_Delete from cart_) radio ispravno, prvo je potrebno izvršiti testni slučaj dodavanja proizvoda u košaricu (_Add to cart_), budući da se proizvodi u košarici gledaju kao lista iz koje se u testnom slučaju brisanja proizvoda briše prvi proizvod iz liste, a drugom proizvodu je vrijednost promijenjena na 1.

Također, kako je korisnik s e-mail adresom martin123@gmail.com korišten u tesnom slučaju registracije, on je već registriran te testni slučaj neće proći, stoga se treba izmijeniti e-mail adresa.

### Autor projekta
Projekt je izradila Kristina Bešlić, studentica 1. godine diplomskog studija Računarstva u Osijeku

