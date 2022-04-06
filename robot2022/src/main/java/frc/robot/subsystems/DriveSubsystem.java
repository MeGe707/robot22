
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.AnalogInPortConstants;
import frc.robot.Constants.CANPortConstants;
import frc.robot.Constants.DIOPortConstants;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
//import edu.wpi.first.math.util.Units;

public class DriveSubsystem extends SubsystemBase {

  private final WPI_TalonSRX leftTalonSRX = new WPI_TalonSRX(CANPortConstants.kDriveTalonLeft);
  private final WPI_TalonSRX rightTalonSRX = new WPI_TalonSRX(CANPortConstants.kDriveTalonRight);
  private final WPI_VictorSPX leftVictorSPX = new WPI_VictorSPX(CANPortConstants.kDriveVictorLeft);
  private final WPI_VictorSPX rightVictorSPX = new WPI_VictorSPX(CANPortConstants.kDriveVictorRight);
  private final MotorControllerGroup rightGroup = new MotorControllerGroup(rightTalonSRX, rightVictorSPX);
  private final MotorControllerGroup leftGroup = new MotorControllerGroup(leftTalonSRX, leftVictorSPX);
  private final DifferentialDrive difDrive = new DifferentialDrive(leftGroup, rightGroup);

  private final AnalogGyro m_gyro = new AnalogGyro(AnalogInPortConstants.kGyroPort);
  private final Encoder leftEncoder = new Encoder(
    DIOPortConstants.kDriveLEncoderPin1, DIOPortConstants.kDriveLEncoderPin2, DriveConstants.kSetLeftEncoderInverted);
  private final Encoder rightEncoder = new Encoder(
    DIOPortConstants.kDriveREncoderPin1, DIOPortConstants.kDriveREncoderPin2, DriveConstants.kSetRightEncoderInverted);
  private double target;
  private final Field2d m_field = new Field2d();
  private NeutralMode defaultMode = NeutralMode.Brake;
  private final DifferentialDriveOdometry m_odometry;


  public DriveSubsystem() {
    leftTalonSRX.setInverted(DriveConstants.kSetLeftTalonInverted);
    rightTalonSRX.setInverted(DriveConstants.kSetRightTalonInverted);
    leftVictorSPX.setInverted(DriveConstants.kSetLeftVictorInverted);
    rightVictorSPX.setInverted(DriveConstants.kSetRightVictorInverted);

    leftTalonSRX.setNeutralMode(defaultMode);
    rightTalonSRX.setNeutralMode(defaultMode);
    leftVictorSPX.setNeutralMode(defaultMode);
    rightVictorSPX.setNeutralMode(defaultMode);

    m_odometry = new DifferentialDriveOdometry(Rotation2d.fromDegrees(getHeading()));
    SmartDashboard.putData("Field", m_field);

    resetEncoders();
    zeroHeading();
  }

  @Override
  public void periodic() {
      // This method will be called once per scheduler run
      m_odometry.update(
              Rotation2d.fromDegrees(getHeading()), getLeftEncoderDistance(), getRightEncoderDistance());

      m_field.setRobotPose(m_odometry.getPoseMeters().getX(), -m_odometry.getPoseMeters().getY(), new Rotation2d(Math.toRadians(-getHeading())));
  }



  public void curvatureDrive (double xSpeed, double zRotation, boolean allowTurnInPlace){
    difDrive.curvatureDrive(xSpeed, zRotation, allowTurnInPlace);
  }

  public void curvatureDriveSlow (double xSpeed, double zRotation, boolean allowTurnInPlace){
    difDrive.curvatureDrive(xSpeed*Constants.DriveConstants.kSlowModeSpeed, zRotation, allowTurnInPlace);
  }

  public void resetEncoders(){
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public void zeroHeading() {
    m_gyro.reset();
  }
  public double getHeading() {
    return Math.IEEEremainder(m_gyro.getAngle(), 360) * (DriveConstants.kGyroReversed ? -1.0 : 1.0);
  }
 
  /** 
    public DifferentialDriveWheelSpeeds getWheelSpeeds() {
    return new DifferentialDriveWheelSpeeds(
      rightTalonSRX.getSelectedSensorVelocity() / DriveConstants.kGearRatio * 2 * Math.PI * DriveConstants.kWheelDiameterMeters / 60,
      leftTalonSRX.getSelectedSensorVelocity() / DriveConstants.kGearRatio * 2 * Math.PI * DriveConstants.kWheelDiameterMeters / 60
    );
  } 
  */

  public DifferentialDriveWheelSpeeds getWheelSpeeds() {
    return new DifferentialDriveWheelSpeeds(
            10.0
                    * rightTalonSRX.getSelectedSensorVelocity()
                    * (1.0 / DriveConstants.kEncoderCPR)
                    * (Math.PI * DriveConstants.kWheelDiameterMeters),
            10.0
                    * leftTalonSRX.getSelectedSensorVelocity()
                    * (1.0 / DriveConstants.kEncoderCPR)
                    * (-Math.PI * DriveConstants.kWheelDiameterMeters));
  }


    public double getLeftWheelVelocity() {
      return getWheelSpeeds().leftMetersPerSecond;
  }

  public double getRightWheelVelocity() {
      return getWheelSpeeds().rightMetersPerSecond;
  }

  public void feedDrive(double leftMotorsVoltage, double rightMotorsVoltage){
    leftGroup.setVoltage(leftMotorsVoltage);
    rightGroup.setVoltage(-rightMotorsVoltage);
    difDrive.feed();
  }

  public double getTurnRate() {
    return m_gyro.getRate() * (DriveConstants.kGyroReversed ? -1.0 : 1.0);
}

  public void resetOdometry(Pose2d pose) {
      resetEncoders();
      m_odometry.resetPosition(pose, Rotation2d.fromDegrees(getHeading()));
  }

  public double getHeadingCW() {
      // Not negating
      return Math.IEEEremainder(m_gyro.getAngle(), 360);
  }
  
  public double getTurnRateCW() {
    // Not negating
    return m_gyro.getRate();
  }

  public double getTarget() {
      return getHeading() + target;
  }

  public void setTarget(double val) {
      target = val;
  }

  public double getRightEncoderDistance() {
    return rightTalonSRX.getSelectedSensorPosition()
            * (1.0 / DriveConstants.kEncoderCPR)
            * (Math.PI * DriveConstants.kWheelDiameterMeters);
  }

  public double getLeftEncoderDistance() {
      return leftTalonSRX.getSelectedSensorPosition()
              * (1.0 / DriveConstants.kEncoderCPR)
              * (-Math.PI * DriveConstants.kWheelDiameterMeters);
  }

  public double getAverageEncoderDistance() {
    return (getRightEncoderDistance() + getLeftEncoderDistance()) / (2.0);
  }

  public void setMaxOutput(double maxOutput) {
    difDrive.setMaxOutput(maxOutput);
  }

  public Pose2d getPose() {
    return m_odometry.getPoseMeters();
  }
}
