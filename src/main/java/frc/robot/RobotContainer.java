// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import SushiFrcLib.Controllers.OI;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.StateMachine;
import frc.robot.commands.TeleopSwerveDrive;
import frc.robot.commands.StateMachine.RobotState;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.Elevator.Elevator;
import frc.robot.subsystems.Intake.BetaIntake;
import frc.robot.subsystems.Intake.Intake;
import frc.robot.subsystems.Shooter.BetaShooter;
import frc.robot.subsystems.Shooter.Shooter;
import frc.robot.subsystems.Indexer.Indexer;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  OI oi;
  Swerve swerve;
  Intake intake;
  Shooter shooter;
  Indexer indexer;
  Elevator elevator;
  // AutoCommands autos;
  StateMachine stateMachine;

  public RobotContainer() {
    oi = OI.getInstance();
    swerve = Swerve.getInstance();
    shooter = BetaShooter.getInstance();
    intake = BetaIntake.getInstance();
    indexer = Indexer.getInstance();
    elevator = Elevator.getInstance();

    stateMachine = new StateMachine(intake, shooter, indexer, elevator);
    // autos = new AutoCommands(swerve);

    configureBindings();
  }

  private void configureBindings() {
    swerve.setDefaultCommand(new TeleopSwerveDrive(
    swerve,
    () -> oi.getDriveTrainTranslationX(),
    () -> oi.getDriveTrainTranslationY(),
    () -> oi.getDriveTrainRotation()));

    oi.getDriverController().a().onTrue(stateMachine.changeState(RobotState.INTAKE));
    oi.getDriverController().b().onTrue(stateMachine.changeState(RobotState.REVERSE)).onFalse(stateMachine.changeState(RobotState.IDLE));

    oi.getDriverController().x().onTrue(stateMachine.changeState(RobotState.SHOOT_FENDOR)).onFalse(stateMachine.changeState(RobotState.IDLE));
    oi.getDriverController().rightTrigger().onTrue(stateMachine.changeState(RobotState.SHOOT_AMP)).onFalse(stateMachine.changeState(RobotState.IDLE));
    // oi.getDriverController().leftTrigger().onTrue(stateMachine.changeState(RobotState.SHOOT_FENDOR));
    oi.getDriverController().leftBumper().onTrue(stateMachine.changeState(RobotState.SHOOT_STAGE));
    // oi.getDriverController().rightBumper().onTrue(stateMachine.changeState(RobotState.SHOOT_TRAP));

    oi.getDriverController().back().onTrue(stateMachine.changeState(RobotState.IDLE));

    // oi.getDriverController().b().whileTrue(elevator.runOpenLoopUp()).onFalse(elevator.stopElevator());
    // oi.getDriverController().y().whileTrue(elevator.runOpenLoopDown()).onFalse(elevator.stopElevator());
  }

  public Command getAutonomousCommand() {
    return null;
    // return autos.getAuto();
  }
}
