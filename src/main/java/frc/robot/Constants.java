// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.util.PIDConstants;

import SushiFrcLib.Control.PIDConfig;
import SushiFrcLib.Motor.MotorConfig;
import SushiFrcLib.Swerve.SwerveConstants.SDSModules;
import SushiFrcLib.Swerve.SwerveConstants.SwerveModuleConstants;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

public final class Constants {
        public static final boolean TUNING_MODE = false;

        public enum Robot {
                ALPHA,
                BETA;
        }

        public static final Robot ROBOT = Robot.BETA;

        public static final class OI {
                public static final double STICK_DEADBAND = 0.1;
        }

        public static class Ports {
                public static final String CANIVORE_NAME = "Sussy Squad";
                public static final int PIGEON_ID = 13;
        }

        public static class Elevator {
                public static final MotorConfig ELEVATOR_LEFT = new MotorConfig(
                                29,
                                10,
                                true,
                                PIDConfig.getPid(0.12),
                                MotorConfig.Mode.BRAKE);

                public static final MotorConfig ELEVATOR_RIGHT = new MotorConfig(
                                30,
                                10,
                                true,
                                PIDConfig.getPid(0.12, 0.0, 0.0),
                                MotorConfig.Mode.BRAKE);

                public static final double G_DOWN = 0;
                public static final double G_UP = 0;

                public static final double MAX_ERROR = 1.0;
        }

        public static final class Swerve {
                public static final boolean GYRO_INVERSION = false; // Always ensure Gyro is CCW+ CW-

                public static final PIDConstants AUTO_TRANSLATION = new PIDConstants(3); // Previouse value modified on
                                                                                         // 3/20/24 15 25
                public static final PIDConstants AUTO_ROTATION = new PIDConstants(0.8); // Previouse value modified on
                                                                                        // 3/20/24 1.5 2.0

                /* Drivetrain Constants */
                public static final double TRACK_WIDTH = Units.inchesToMeters(23);
                public static final double WHEEL_BASE = Units.inchesToMeters(23);

                public static final double DRIVE_BASE_RADIUS = Math
                                .sqrt(TRACK_WIDTH * TRACK_WIDTH + WHEEL_BASE * WHEEL_BASE) / 2;

                public static final SwerveDriveKinematics SWERVE_KINEMATICS = new SwerveDriveKinematics(
                                new Translation2d(WHEEL_BASE / 2.0, TRACK_WIDTH / 2.0),
                                new Translation2d(WHEEL_BASE / 2.0, -TRACK_WIDTH / 2.0),
                                new Translation2d(-WHEEL_BASE / 2.0, -TRACK_WIDTH / 2.0),
                                new Translation2d(-WHEEL_BASE / 2.0, TRACK_WIDTH / 2.0));

                public static final MotorConfig ANGLE_CONFIG = new MotorConfig(
                                20,
                                false, // Make true if we have a stroke
                                PIDConfig.getPid(0.1), // TODO: retune
                                MotorConfig.Mode.COAST);

                public static final MotorConfig ANGLE_FLIPPED_CONFIG = new MotorConfig(
                                20,
                                true, // Make true if we have a stroke
                                PIDConfig.getPid(0.1), // TODO: retune
                                MotorConfig.Mode.COAST);

                public static final MotorConfig DRIVE_CONFIG = new MotorConfig(
                                40,
                                true,
                                PIDConfig.getPid(0.2, 0.68),
                                MotorConfig.Mode.BRAKE);

                public static final MotorConfig DRIVE_FLIPPED_CONFIG = new MotorConfig(
                                40,
                                false,
                                PIDConfig.getPid(0.2, 0.68),
                                MotorConfig.Mode.BRAKE);

                public static final PIDConfig autoRotate = PIDConfig.getPid(0.008, 0.00, 0.00);

                public static final SDSModules MODULE_TYPE = SDSModules.MK4i;

                public static final boolean SWERVE_TUNING_MODE = false;

                public static final SwerveModuleConstants[] SWERVE_MODULE_CONSTANTS = new SwerveModuleConstants[] {
                                new SwerveModuleConstants(0, Rotation2d.fromDegrees(0.461182 * 360), MODULE_TYPE,
                                                SWERVE_TUNING_MODE, DRIVE_CONFIG, ANGLE_CONFIG),
                                new SwerveModuleConstants(1, Rotation2d.fromDegrees(0.561035 * 360), MODULE_TYPE,
                                                SWERVE_TUNING_MODE, DRIVE_FLIPPED_CONFIG, ANGLE_FLIPPED_CONFIG),
                                new SwerveModuleConstants(2, Rotation2d.fromDegrees(0.570557 * 360), MODULE_TYPE,
                                                SWERVE_TUNING_MODE, DRIVE_CONFIG, ANGLE_CONFIG),
                                new SwerveModuleConstants(3, Rotation2d.fromDegrees(0.336426 * 360 + 180), MODULE_TYPE,
                                                SWERVE_TUNING_MODE, DRIVE_FLIPPED_CONFIG, ANGLE_FLIPPED_CONFIG),
                };
        }

        public static final class Manipulator {
                public static final MotorConfig KICKER_CONFIG = new MotorConfig(
                                25,
                                40,
                                false,
                                MotorConfig.Mode.BRAKE);

                public static final MotorConfig PIVOT_CONFIG = new MotorConfig(
                                26,
                                20,
                                false,
                                PIDConfig.getPid(0.03, 0.000, 2.5, 0.0), // 0.04 1.5
                                MotorConfig.Mode.BRAKE);

                public static final MotorConfig SHOOTER_CONFIG_TOP = new MotorConfig(
                                27,
                                40,
                                true,
                                PIDConfig.getPid(0.0),
                                MotorConfig.Mode.BRAKE);

                public static final MotorConfig SHOOTER_CONFIG_BOTTOM = new MotorConfig(
                                28,
                                40,
                                true,
                                PIDConfig.getPid(0.00002, 0.0, 0.000174), //0.00009, 0.0, 0.000174
                                MotorConfig.Mode.BRAKE);

                public static final int ENCODER_ID = 4;
                public static final double ENCODER_OFFSET = -49;// 82;//-142.1;
                public static final double PIVOT_GEAR_RATIO = 66.666;
                public static final double KS = 0;
                public static final double KG = 0.21;
                public static final double KV = 0;
                public static final double KICKER_SPEED = 0.6;// set this

                public static final double SHOOTER_SPEED = 5000;

                public static final double PIVOT_AMP_ANGLE = 22; // find angle
                public static final double PIVOT_TRAP_ANGLE = 0; // find angle
                public static final double PIVOT_STAGE_ANGLE = -41; // 31.5
                public static final double PIVOT_IDLE = -54.4; // -60
                public static final double PIVOT_CENTER_ANGLE = -25;
                public static final double SHOOTER_ERROR = 300;
                public static final double PIVOT_ERROR = 1.0;
        }

        public static final class Indexer {
                public static int BEAM_BREAK;

                static {
                        switch (ROBOT) {
                                case ALPHA:
                                        BEAM_BREAK = 1;
                                        break;
                                default:
                                        BEAM_BREAK = 0;

                        }
                }

                public static final double UPRIGHT_ROLLERS_SPEED = 0.9;
                public static final double INDEXER_SPEED = 0.7;
                public static final MotorConfig INDEXER_CONFIG = new MotorConfig(
                                24,
                                40, // set later
                                false, // spin motor
                                MotorConfig.Mode.COAST);
                public static final MotorConfig UPRIGHT_ROLLERS_CONFIG = new MotorConfig(
                                23, // set canID later
                                20,
                                true, // position motor
                                MotorConfig.Mode.COAST);
        }

        public static final class Intake {
                public static final double G = 0.25; // retune
                public static final int ENCODER_CHANNEL = 1;
                public static final double ENCODER_ANGLE_OFFSET = 71; // 60
                public static final double INTAKE_GEAR_RATIO = 21.701;

                public static final double INTAKE_SPEED = 0.5;

                public static final double ERROR_LIMIT = 1.0;
                public static final double MAX_ERROR = 4.0;

                public static final double RAISED_POS = 110;
                public static final double LOWERED_POS = -12; // -26

                public static final MotorConfig INTAKE_CONFIG = new MotorConfig(
                                21,
                                40, // set later
                                true, // spin motor
                                MotorConfig.Mode.COAST);

                public static final MotorConfig PIVOT_CONFIG = new MotorConfig(
                                22,
                                20,
                                true,
                                PIDConfig.getPid(0.009, 0.01, 0.0), // p:0.012d:0.6
                                MotorConfig.Mode.BRAKE);
        }
}
