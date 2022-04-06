
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANPortConstants;
import frc.robot.Constants.HangerConstants;

public class HangerSubsystem extends SubsystemBase {

  private final WPI_VictorSPX motorLeft = new WPI_VictorSPX(CANPortConstants.kHangerVictorLeft);
  private final WPI_VictorSPX motorRight = new WPI_VictorSPX(CANPortConstants.kHangerVictorLeft);
  private final MotorControllerGroup motors = new MotorControllerGroup(motorLeft, motorRight);

  
  public HangerSubsystem() {      
    motorLeft.setInverted(HangerConstants.kSetLeftMotorInverted);
    motorRight.setInverted(HangerConstants.kSetRightMotorInverted);
  }

  public void openMotor(){
    motors.set(HangerConstants.kHangerSpeed);
  }

  public void reverseMotor(){
    motors.set(-HangerConstants.kHangerSpeed);
  }

  public void stopMotor(){
    motors.stopMotor();
  }

}