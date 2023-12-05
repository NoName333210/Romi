/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;


public class Forward extends CommandBase {

  // on utilise des distances en pouces... oh well
  public double distance;

  public Forward(double inches) {
    // on indique qu'on a besoin du chassis
    addRequirements(RobotContainer.chassis);
   RobotContainer.chassis.drive(distance,inches);
  }

  @Override
  public void initialize() {
    // à l'initialisation de la commande, on remet le chassis à 0
    RobotContainer.chassis.reset();
  }

  @Override
  public void execute() {
    // on va tout droit à la vitesse choisie... suggestion 15%
    RobotContainer.chassis.drive(0.15, distance);
  }

  @Override
  public void end(boolean interrupted) {
    // quand la commande a terminée, on arrête le chassis
RobotContainer.chassis.stop();
  }

  @Override
  public boolean isFinished() {
    // quand une des roues à parcourue la distance souhaitée, c'est fini
    return Math.abs(RobotContainer.chassis.getRightDistance()) >= distance;
  }
}
