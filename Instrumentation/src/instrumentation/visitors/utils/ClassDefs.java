/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors.utils;

/**
 *
 * @author User
 */
public class ClassDefs {
    private String pack;
    private String name;
    private String appName;
    private boolean isLauncher;
    private boolean isActivity;
    private boolean tests;
    private boolean instrumented;
    private boolean hasStop;
    private boolean suite;
    private boolean setUp;
    private boolean tearDown;

    public ClassDefs() {
        this.hasStop = false;
        this.isActivity = false;
        this.isLauncher = false;
    }

    public ClassDefs(String pack, String name, String app) {
        this.pack = pack;
        this.name = name;
        this.appName = app;
        this.hasStop = false;
        this.isActivity = false;
        this.isLauncher = false;
        this.instrumented = false;
        this.setUp = false;
        this.tearDown = false;
        this.suite = false;
        this.tests = false;
    }

    public boolean hasTests() {
        return tests;
    }

    public void setTests(boolean tests) {
        this.tests = tests;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public boolean isLauncher() {
        return isLauncher;
    }

    public void setLauncher(boolean isLauncher) {
        this.isLauncher = isLauncher;
    }

    public boolean isActivity() {
        return isActivity;
    }

    public void setActivity(boolean isActivity) {
        this.isActivity = isActivity;
    }

    public boolean isInstrumented() {
        return instrumented;
    }

    public void setInstrumented(boolean instrumented) {
        this.instrumented = instrumented;
    }

    public boolean hasStop() {
        return hasStop;
    }

    public void setStop(boolean hasStop) {
        this.hasStop = hasStop;
    }
    
    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSuite() {
        return suite;
    }

    public void setSuite(boolean suite) {
        this.suite = suite;
    }

    public boolean hasSetUp() {
        return setUp;
    }

    public void setSetUp(boolean setUp) {
        this.setUp = setUp;
    }

    public boolean hasTearDown() {
        return tearDown;
    }

    public void setTearDown(boolean tearDown) {
        this.tearDown = tearDown;
    }
    
    
    public String getDescriptor(){
        return pack+"."+name;
    }
}
