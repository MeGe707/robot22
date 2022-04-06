
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANPortConstants;
import frc.robot.Constants.IndexerConstants;

public class IndexerSubsystem extends SubsystemBase {

  private final WPI_VictorSPX redline = new WPI_VictorSPX(CANPortConstants.kIndexerVictor);
  
  
  public IndexerSubsystem() {      
    redline.setInverted(IndexerConstants.kSetMotorInverted);
  }

  public void openRedline(){
    redline.set(IndexerConstants.kIndexerSpeed);
  }

  public void reverseRedline(){
    redline.set(-IndexerConstants.kIndexerSpeed);
  }
  
  public void stopRedline(){
    redline.stopMotor();
  }

}