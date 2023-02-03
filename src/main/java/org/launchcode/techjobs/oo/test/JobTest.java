package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job job6;

    @Before
    public void createJobObjects() {
        Job job1 = new Job();
        Job job2 = new Job();
        job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.getId() == job2.getId());
    }

    @Test
    public void testJobIdsAreIncremented() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertTrue(job2.getId() == (job1.getId() + 1));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals(job3.getName(), "Product tester");
        assertEquals(job3.getEmployer().getValue(), "ACME");
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertEquals(job3.getPositionType().getValue(), "Quality Control");
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue((job3.getCoreCompetency() instanceof CoreCompetency));
        assertTrue(job3.getName() instanceof String);
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        //assertFalse(job4.getId() == job5.getId());
        assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job job99 = new Job("A", new Employer("B"), new Location("C"), new PositionType("D"), new CoreCompetency("E"));
        String testOut = "\nName: A\nEmployer: B\nLocation: C\nPosition Type: D\nCore Competency: E\n";
        assertEquals(job99.toString().endsWith("\nName: A\nEmployer: B\nLocation: C\nPosition Type: D\nCore Competency: E\n"), testOut.endsWith("\nName: A\nEmployer: B\nLocation: C\nPosition Type: D\nCore Competency: E\n"));
        Job job77 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        String test = "\nID: 4\nName: Product Tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality Control\nCore Competency: Persistence\n";
        assertTrue(job77.toString().startsWith("\n"));
        assertTrue(job77.toString().endsWith("\n"));
        String testNewLine = "\n";
        assertEquals(job77.toString().charAt(0), testNewLine.charAt(0));
        assertEquals(job77.toString().charAt(job77.toString().length() - 1), testNewLine.charAt(0));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals(job.toString(), "\nID: " + job.getId() + "\nName: " + job.getName() + "\nEmployer: " + job.getEmployer().getValue() + "\nLocation: " + job.getLocation().getValue() + "\nPosition Type: " + job.getPositionType().getValue() + "\nCore Competency: " + job.getCoreCompetency().getValue() + "\n");
        assertTrue(job.toString().contains("ID:"));
        assertTrue(job.toString().contains("Name:"));
        assertTrue(job.toString().contains("Employer:"));
        assertTrue(job.toString().contains("Location:"));
        assertTrue(job.toString().contains("Position Type:"));
        assertTrue(job.toString().contains("Core Competency:"));
        assertTrue(job.toString().contains(Integer.toString(job.getId())));
        assertTrue(job.toString().contains(job.getName()));
        assertTrue(job.toString().contains(job.getEmployer().getValue()));
        assertTrue(job.toString().contains(job.getLocation().getValue()));
        assertTrue(job.toString().contains(job.getPositionType().getValue()));
        assertTrue(job.toString().contains(job.getCoreCompetency().getValue()));
        assertTrue(job.toString().contains("\nID: " + Integer.toString(job.getId()) + "\n"));
        assertTrue(job.toString().contains("\nName: " + job.getName() + "\n"));
        assertTrue(job.toString().contains("\nEmployer: " + job.getEmployer().getValue() + "\n"));
        assertTrue(job.toString().contains("\nLocation: " + job.getLocation().getValue() + "\n"));
        assertTrue(job.toString().contains("\nPosition Type: " + job.getPositionType().getValue() + "\n"));
        assertTrue(job.toString().contains("\nCore Competency: " + job.getCoreCompetency().getValue() + "\n"));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Employer acme = new Employer("ACME");
        Location desert = new Location("Desert");
        PositionType qc = new PositionType("Quality Control");
        CoreCompetency persistence = new CoreCompetency("Persistence");
        Job job7 = new Job("Product tester", acme, desert, qc, persistence);

        job7.setName("");
        assertTrue(job7.toString().contains("Name: Data not available"));
        assertEquals(job7.toString(), "\nID: 18\nName: Data not available\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality Control\nCore Competency: Persistence\n");
        job7.setName("Product tester");

        job7.setEmployer(new Employer(""));
        assertTrue(job7.toString().contains("Employer: Data not available"));
        job7.setEmployer(acme);
        job7.setLocation(new Location(""));
        assertTrue(job7.toString().contains("Location: Data not available"));
        job7.setLocation(desert);
        job7.setPositionType(new PositionType(""));
        assertTrue(job7.toString().contains("Position Type: Data not available"));
        job7.setPositionType(qc);
        job7.setCoreCompetency(new CoreCompetency(""));
        assertTrue(job7.toString().contains("Core Competency: Data not available"));
        job7.setCoreCompetency(persistence);
    }




    @Test
    public void toStringPrintsSpecialMessageIfNoData() {
        Job job8 = new Job();
        System.out.println("job8 Id = " + job8.getId());
        System.out.println(Objects.isNull(job8.getName()));
        assertTrue(job8.toString().equals("\nOOPS! This job does not seem to exist.\n"));
    }
}

