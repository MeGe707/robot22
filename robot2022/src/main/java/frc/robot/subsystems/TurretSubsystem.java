
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANPortConstants;
import frc.robot.Constants.DIOPortConstants;
import frc.robot.Constants.TurretConstants;

public class TurretSubsystem extends SubsystemBase {
  private final double turretLimitDegrees = TurretConstants.kTurnLimitDegrees;
  private final double turretLeftMoveLimit = -turretLimitDegrees/2;
  private final double turretRightMoveLimit = turretLimitDegrees/2;
  private final WPI_VictorSPX redline = new WPI_VictorSPX(CANPortConstants.kTurretVictor);

  // Initializes an encoder on DIO pins 0 and 1
  private final Encoder encoder = new Encoder(
    DIOPortConstants.kTurretEncoderPin1, DIOPortConstants.kTurretEncoderPin1,
    TurretConstants.kSetEncoderInverted);

  
  public TurretSubsystem() {      
    redline.setInverted(false);
    // Configures the encoder to return a distance of 360 for every 256 pulses
    // 0.25 symbolizes number of full turns of turret per one turn of the motor
    encoder.setDistancePerPulse(
      TurretConstants.kTurretTurnsPerMotorTurn*360./TurretConstants.kEncoderPulse);
      encoder.reset();
  }
  
  public void openRedline(){
    redline.set(TurretConstants.kTurretSpeed);
  }

  public void stopRedline(){
    redline.stopMotor();
  }
  
  public void setRedline(double speed){
    redline.set(speed);
  }

  public void moveTurretLeft(){
    if(encoder.getDistance() >= turretLeftMoveLimit
      && encoder.getDistance() <= turretRightMoveLimit)
        redline.set(-TurretConstants.kTurretSpeed);
  }

  public void moveTurretRight(){
    if(encoder.getDistance() >= turretLeftMoveLimit
      && encoder.getDistance() <= turretRightMoveLimit)
        redline.set(TurretConstants.kTurretSpeed);
  }
}