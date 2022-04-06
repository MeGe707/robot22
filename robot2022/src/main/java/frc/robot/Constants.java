// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class JoystickConstants {        
        public static final int kDriverControllerPort = 0;
        public static final int kOperatorControllerPort = 1;
        //driver's joystick settings
        public static final int kDriveSpeedAxis = 0;
        public static final int kDriveTurnAxis = 0;
        public static final int kObjectInComButton = 0;
        public static final int kObjectOutComButton = 0;
        public static final int kSolenoidComButton = 0;
        public static final int kSlowDriveButton = 0;
        //operator's joystick settings
        public static final int kObjectShootComButton = 0;
        public static final int kTurretTurnLeftButton = 0;
        public static final int kTurretTurnRightButton = 0;
    }

    public static final class DIOPortConstants {
        public static final int kTurretEncoderPin1 = 0;
        public static final int kTurretEncoderPin2 = 0;
        
        public static final int kShooterEncoderPin1 = 0;
        public static final int kShooterEncoderPin2 = 0;

        //left encoder
        public static final int kDriveLEncoderPin1 = 0;
        public static final int kDriveLEncoderPin2 = 0;
        //right encoder
        public static final int kDriveREncoderPin1 = 0;
        public static final int kDriveREncoderPin2 = 0;
    }

    public static final class AnalogInPortConstants {
        public static final int kGyroPort = 0;
    }

    public static final class PWMPortConstants {}

    public static final class CANPortConstants {
        public static final int kDriveTalonLeft = 0;
        public static final int kDriveTalonRight = 0;
        public static final int kDriveVictorLeft = 0;
        public static final int kDriveVictorRight = 0;
        public static final int kHopperVictor = 0;
        public static final int kIndexerVictor = 0;
        public static final int kIntakeVictor = 0;
        public static final int kLimitBVictor = 0;
        public static final int kShooterVictorLeft = 0;
        public static final int kShooterVictorRight = 0;       
        public static final int kTurretVictor = 0;
        public static final int kHangerVictorLeft = 0;
        public static final int kHangerVictorRight = 0;
    }

    public static final class HopperConstants {
        public static final double kHopperSpeed = 0.7;
        public static final boolean kSetMotorInverted = false;
    }

    public static final class IndexerConstants {
        public static final double kIndexerSpeed = 0.7;
        public static final boolean kSetMotorInverted = false;
    }

    public static final class IntakeConstants {
        public static final double kIntakeSpeed = 0.7;
        public static final boolean kSetMotorInverted = false;
        public static final int kSolenoidChannel = 0;
    }

    public static final class LimitBConstants {
        public static final double kLimitBSpeed = 0.9;
        public static final boolean kSetMotorInverted = false;
    }

    public static final class HangerConstants {
        public static final double kHangerSpeed = 0.7;
        public static final boolean kSetLeftMotorInverted = false;
        public static final boolean kSetRightMotorInverted = false;
    }

    public static final class ShooterConstants {
        public static final double kShooterSpeed = 0.9;
        public static final double kWaitToStartSecs = 1;
        public static final boolean kSetLeftMotorInverted = false;
        public static final boolean kSetRightMotorInverted = false;
        public static final boolean kSetEncoderInverted = false;
    }

    public static final class TurretConstants {
        public static final double kTurretSpeed = 0.7;
        public static final boolean kSetMotorInverted = false;
        public static final boolean kSetEncoderInverted = false;
        public static final double kEncoderPulse = 256.;
        //gearbox completes one full turn per 71 turns of the motor
        //turret completes one full turn per 28/3 turns of the gearbox
        public static final double kTurretTurnsPerMotorTurn = 1/(71*(28/3));
        public static final double kTurnLimitDegrees = 270;
    }


    public static final class PIDConstants {
        public static final double Pose2d_AxisX = 0;
        public static final double Pose2d_AxisY = 0;
        
        public static final double kStraightDriveP = 1;
        public static final double kStraightDriveI = 0;
        public static final double kStraightDriveD = 0;
        public static final double kStraightDriveAccuracy = 0.1;

        public static final double kStraightDriveTurnP = 1;
        public static final double kStraightDriveTurnI = 0;
        public static final double kStraightDriveTurnD = 0;
        public static final double kStraightDriveTurnAccuracy = 2;
        public static final double kStraightDriveMaxVolts = 10;
        public static final double kStraightDriveMinVolts = 2;

        public static final double kPurePursuitLookAheadDistance = 0.1;

        public static final double kPathFollowP = 5.0; // 0.1;
        public static final double kPathFollowI = 0.3; // 1.5;
        public static final double kPathFollowD = 0;
        public static final double kPathFollowVelocityTolerance = 0;

    }
    
    public static final class DriveConstants {
        //drive in half speed mode
        public static final double kSlowModeSpeed = 0.5;
        public static final boolean kSetLeftTalonInverted = false;
        public static final boolean kSetRightTalonInverted = false;
        public static final boolean kSetLeftVictorInverted = false;
        public static final boolean kSetRightVictorInverted = false;
        public static final boolean kSetLeftEncoderInverted = false;
        public static final boolean kSetRightEncoderInverted = false;


        public static final double ksVolts = 1.2;
        public static final double kvVoltSecondsPerMeter = 4.5; // 10.5
        //The kA gain can be omitted, and if it is, will default to a value of zero. 
        //For many mechanisms, especially those with little inertia, it is not necessary.
        public static final double kaVoltSecondsSquaredPerMeter = 2; // 4.09
        public static final double kMaxAccelerationMetersPerSecondSquared = 1; // 1.5
        public static final double kMaxSpeedMetersPerSecond = 1.5; // 2
        public static final double kRamseteB = 2;
        public static final double kPDriveVel = 1.88; // 0.935
        public static final double kRamseteZeta = 0.7;
        public static final double kTrackwidthMeters = 0.65;
        public static final double kMaxAutoVoltage = 10;

        public static final DifferentialDriveKinematics kDriveKinematics =
            new DifferentialDriveKinematics(kTrackwidthMeters);
        public static final boolean kGyroReversed = false;

        //cpr = ppr*4
        public static final double kEncoderCPR = 0; //4096;
        public static final double kWheelDiameterMeters = 0.1524;
        public static final double kGearRatio = 0;
    }
}