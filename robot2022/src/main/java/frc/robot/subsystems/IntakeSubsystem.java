package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANPortConstants;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {

  private final WPI_VictorSPX redline = new WPI_VictorSPX(CANPortConstants.kIntakeVictor);
  private final Solenoid solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, IntakeConstants.kSolenoidChannel);


  public void openRedline(){
    redline.set(IntakeConstants.kIntakeSpeed);
  }
  
  public void reverseRedline(){
    redline.set(-IntakeConstants.kIntakeSpeed);
  }

  public void stopRedline(){
    redline.stopMotor();
  }

  public void openSolenoid(){
    solenoid.set(true);
  }

  public void stopSolenoid(){
    solenoid.set(false);
  }

}