package Steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.BankManager;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankManagerStep {

    private BankManager bankManager;

    private Integer id;
    private double i_montant;

    @Given("Un nouveau compte est creer un compte {int} avec un solde initial de {int}")
    public void un_nouveau_compte_est_créer_un_compte_avec_un_solde_initial_de(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("given");
        bankManager=new BankManager();
        bankManager.create(int1);
        bankManager.deposit(int1,int2);
    }
    @When("je depose {int} sur le compte {int}")
    public void je_depose_sur_le_compte1(Integer int1, Integer int2) {
        System.out.println("when");
        bankManager.deposit(int2,int1);
    }
    @Then("le solde du compte {int} est de {int}")
    public void le_solde_du_compte_est_de(int int1, int int2) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("then");
        assertEquals(int2, bankManager.getBalance(int1));
    }

    @Given("Un nouveau compte bancaire est creer un compte {int} avec un solde initial de {int}")
    public void un_nouveau_compte_bancaire_est_creer_un_compte_avec_un_solde_initial_de(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("given 2 ");
        bankManager=new BankManager();
        bankManager.create(int1);
        bankManager.deposit(int1,int2);
    }
    @When("je depose {int} sur le compte {int} puis je retire {int}")
    public void je_depose_sur_le_compte_puis_je_retire(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("when2");
        bankManager.deposit(int2,int1);
        bankManager.withdraw(int2,int3);
    }
    @Then("le solde du compte {int} est maintenant de {int}")
    public void le_solde_du_compte_est_maintenant_de(int int1, int int2) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("then2");
        assertEquals(int2, bankManager.getBalance(int1));
    }


    @Given("Deux nouveau compte bancaire sont creer un compte {int} et compte {int} avec un solde initial de {int}")
    public void deux_nouveau_compte_bancaire_sont_creer_un_compte_et_compte_avec_un_solde_initial_de(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("given 3 ");
        bankManager=new BankManager();
        bankManager.create(int1);
        bankManager.create(int2);
        bankManager.deposit(int1,int3);
        bankManager.deposit(int2,int3);

    }
    @When("je retire {int} sur le compte {int} puis je les depose sur le compte {int}")
    public void je_retire_sur_le_compte_puis_je_depose_sur_le_compte(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("when2");
        bankManager.withdraw(int2,int1);
        bankManager.deposit(int3,int1);

    }
    @Then("le solde du compte {int} est maintenant de {int} et le solde {int} est {int}")
    public void le_solde_du_compte_est_maintenant_de_et_le_solde_est(int int1, int int2, int int3, int int4) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("then3");
        assertEquals(int2, bankManager.getBalance(int1));
        assertEquals(int4, bankManager.getBalance(int3));
    }

}
