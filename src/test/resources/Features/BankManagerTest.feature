@US1
Feature: test de la banque
  En tant que manager
  Je veux gerer les comptes
  Afin de connaitre la situation du bank


  @Depot
  Scenario Outline: Création et dépot
    Given Un nouveau compte est creer un compte <num> avec un solde initial de <solde>
    When je depose <montant> sur le compte <num>
    Then le solde du compte <num> est de <attendu>
    Examples:
      | num | solde | montant | attendu |
      | 1   | 1000  | 500     | 1500    |
      | 2   | 0     | 2000    | 2000    |

  @Retrait
  Scenario Outline: Creation depot et retrait
    Given Un nouveau compte bancaire est creer un compte <num> avec un solde initial de <solde>
    When je depose <montant> sur le compte <num> puis je retire <montant2>
    Then le solde du compte <num> est maintenant de <attendu>
    Examples:
      | num | solde | montant | montant2 | attendu |
      | 1   | 1000  | 500     | 200      | 1300    |
      | 2   | 0     | 2000    | 1000     | 1000    |

  @Epargne
  Scenario Outline: Creer un scénario d'envoyer l'argent du compte 3 au compte 1
    Given Deux nouveau compte bancaire sont creer un compte <num> et compte <num2> avec un solde initial de <solde>
    When je retire <montant> sur le compte <num> puis je les depose sur le compte <num2>
    Then le solde du compte <num> est maintenant de <attendu> et le solde <num2> est <attendu2>
    Examples:
      | num | num2 | solde | montant | attendu | attendu2 |
      | 1   | 3    | 500   | 500     | 0       | 1000     |
      | 1   | 3    | 500   | 200     | 300     | 700      |




