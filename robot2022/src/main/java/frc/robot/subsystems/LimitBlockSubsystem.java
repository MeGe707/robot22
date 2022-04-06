
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANPortConstants;
import frc.robot.Constants.LimitBConstants;

public class LimitBlockSubsystem extends SubsystemBase {

  private final WPI_VictorSPX redline = new WPI_VictorSPX(CANPortConstants.kLimitBVictor);

  
  public LimitBlockSubsystem() {      
    redline.setInverted(LimitBConstants.kSetMotorInverted);
  }

  public void openRedline(){
    redline.set(LimitBConstants.kLimitBSpeed);
  }

  public void reverseRedline(){
    redline.set(-LimitBConstants.kLimitBSpeed);
  }

  public void stopRedline(){
    redline.stopMotor();
  }

}