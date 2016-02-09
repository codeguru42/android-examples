package codeguru.testnextbutton;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class NextButtonTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    private UiDevice device;

    @Before
    public void setUp() {
        Instrumentation inst = InstrumentationRegistry.getInstrumentation();
        device = UiDevice.getInstance(inst);
    }

    @Test
    public void testNextButton() {
        onView(withId(R.id.first_text)).check(matches(hasFocus()));
        device.pressEnter();
        onView(withId(R.id.second_text)).check(matches(hasFocus()));
    }
}
