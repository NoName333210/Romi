/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DefaultDrive extends CommandBase {
  /**
   * Creates a new DefaultDrive.
   */
  public DefaultDrive() {
    // on indique qu'on a besoin du chassis
    addRequirements(RobotContainer.chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // on prend la vitesse de l'axe #1 du joystick et la direction provient de l'axe 3
    RobotContainer.chassis.drive(RobotContainer.joystick.getRawAxis(1), RobotContainer.joystick.getRawAxis(3));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // cette commande ne fini jamais...
    return true;
  }
}
