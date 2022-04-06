
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANPortConstants;
import frc.robot.Constants.HopperConstants;

public class HopperSubsystem extends SubsystemBase {

private final WPI_VictorSPX redline = new WPI_VictorSPX(CANPortConstants.kHopperVictor);


  public HopperSubsystem() {
      redline.setInverted(HopperConstants.kSetMotorInverted);
  }

  public void openRedline(){
    redline.set(HopperConstants.kHopperSpeed);
  }
  
  public void reverseRedline(){
    redline.set(-HopperConstants.kHopperSpeed);
  }

  public void stopRedline(){
    redline.stopMotor();
  }

}