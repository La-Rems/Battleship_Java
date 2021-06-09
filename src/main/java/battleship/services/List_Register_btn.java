package battleship.services;

import battleship.graphics.IG_Register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class List_Register_btn implements ActionListener {
    private Register register;
    private IG_Register ig_register;
    Boolean response;

    public List_Register_btn(IG_Register ig_register){
        this.register = ig_register.register;
        this.ig_register = ig_register;
    }
    @Override
    public void actionPerformed(ActionEvent e){

        response = this.register.SignUp(this.ig_register.getPseudoRegister(), this.ig_register.getPasswordRegister1(), this.ig_register.getPasswordRegister2());
        if (response){
            this.ig_register.register_success.setText("Register Successful, Please Log in");
        } else  {
            this.ig_register.register_error.setText("Login already in use or Passwords doesn't match");
        }
    }
}
