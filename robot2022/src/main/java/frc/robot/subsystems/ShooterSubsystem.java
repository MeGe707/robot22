
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANPortConstants;
import frc.robot.Constants.DIOPortConstants;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {

  private final WPI_VictorSPX redlineLeft = new WPI_VictorSPX(CANPortConstants.kShooterVictorLeft);
  private final WPI_VictorSPX redlineRight = new WPI_VictorSPX(CANPortConstants.kShooterVictorRight);
  private final MotorControllerGroup redlines = new MotorControllerGroup(redlineLeft, redlineRight);
  private final Timer timer = new Timer();
  
  private final Encoder encoder = new Encoder(
    DIOPortConstants.kShooterEncoderPin1, DIOPortConstants.kShooterEncoderPin2,
    ShooterConstants.kSetEncoderInverted);

  
  public ShooterSubsystem() {      
    redlineLeft.setInverted(ShooterConstants.kSetLeftMotorInverted);
    redlineRight.setInverted(ShooterConstants.kSetRightMotorInverted);

    encoder.reset();
  }

  public void openRedline(){
    redlines.set(ShooterConstants.kShooterSpeed);
  }

  public void stopRedline(){
    redlines.stopMotor();
  }

  public void setRedline(double speed){
    redlines.set(speed);
  }

  public void resetStartTimer(){
    timer.reset();
    timer.start();
  }

  public double getTimer(){
    return timer.get();
  }

  public void stopTimer(){
    timer.stop();
  }
}