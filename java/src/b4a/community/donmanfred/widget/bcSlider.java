package b4a.community.donmanfred.widget;



import com.rey.material.widget.Slider;
import com.rey.material.widget.Slider.OnPositionChangeListener;

import android.view.ViewGroup;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.Pixel;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.ViewWrapper;

@ShortName("bcSlider")
//@Permissions(values={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
@Events(values={
		"onPositionChanged(v As Object, oldPos As Float, newPos As Float, oldValue As Int, newValue As Int)"
//		"onhourchanged(oldValue As int, newValue As int)",
//		"onminutechanged(oldValue As int, newValue As int)"
		})
//@DependsOn(values={"android-viewbadger"})
public class bcSlider extends ViewWrapper<Slider>  implements DesignerCustomView {
	private BA ba;
	private String eventName;
	 

	
	/*
	 * Initialize the HTML-TextView 
	 */   	
	@Override
	public void Initialize(final BA ba, String EventName) {
		_initialize(ba, null, EventName);
	}
	
	@Override
	@Hide
	public void _initialize(final BA ba, Object activityClass, String EventName) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;
		this.setObject(new Slider(ba.context));
		this.getObject().setOnPositionChangeListener(new OnPositionChangeListener(){

			@Override
			public void onPositionChanged(Slider view, float oldPos, float newPos, int oldValue, int newValue) {
				// TODO Auto-generated method stub
				if (ba.subExists(eventName + "_onpositionchanged")) {
					//ba.Log("lib:Raising.. "+eventName + "_onpositionchanged()");								
					ba.raiseEvent(ba.context, eventName+"_onpositionchanged", view, oldPos, newPos, oldValue, newValue);
					//ba.raiseEventFromDifferentThread(ba.context, null, 0, eventName + "_onmodechanged", true, new Object[] {mode});
				}else {
					BA.Log("lib: NOTFOUND '"+eventName + "_onpositionchanged");
				}

			}
			
		});
 	}

	@Override
	public void setTag(Object tag){
		this.getObject().setTag(tag);
	}
	@Override
	public Object getTag(){
		return this.getObject().getTag();
	}
	
	public int getValue() {
		return this.getObject().getValue();
	}

	public float getExactValue() {
		return this.getObject().getExactValue();
	}

	public float getPosition() {
		return this.getObject().getPosition();
	}

	public void setPosition(float pos, boolean animation) {
		this.getObject().setPosition(pos, animation);
	}
	public void setValue(float value, boolean animation) {
		this.getObject().setValue(value, animation);
	}


	public int getMinValue() {
		return this.getObject().getMinValue();
	}

	public void setMinValue(int MinValue) {
		this.getObject().setMinValue(MinValue);
	}

	public int getMaxValue() {
		return this.getObject().getMaxValue();
	}

	public void setMaxValue(int MaxValue) {
		this.getObject().setMaxValue(MaxValue);
	}

	public int getStepValue() {
		return this.getObject().getStepValue();
	}

	public void setStepValue(int StepValue) {
		this.getObject().setStepValue(StepValue);
	}

	public boolean isDiscreteMode() {
		return this.getObject().isDiscreteMode();
	}

	public void setDiscreteMode(boolean DiscreteMode) {
		this.getObject().setDiscreteMode(DiscreteMode);
	}
	
	
	//programmatically add view
	public void AddToParent(ViewGroup Parent, @Pixel int left, @Pixel int top, @Pixel int width, @Pixel int height) {
		//AttributeSet attrs;		
		//XmlPullParser parser = Resources.getXml(myResouce);
		//AttributeSet myAttributes = Xml.asAttributeSet(parser);
		//AttributeSet myAttributes = null;
		//anywheresoftware.b4a.		 
		//mSignaturePad = new SignaturePad(ba.context, myAttributes);
		Parent.addView(this.getObject(), new BALayout.LayoutParams(left, top, width, height));
	}
	
	//this method cannot be hidden.
	@Override
	public void DesignerCreateView(PanelWrapper base, LabelWrapper lw, anywheresoftware.b4a.objects.collections.Map props) {
		ViewGroup vg = (ViewGroup) base.getObject().getParent();
		AddToParent(vg, base.getLeft(), base.getTop(), base.getWidth(), base.getHeight());
		base.RemoveView();
		//set text properties
	}

	@Override
	public void setLeft(int left)	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)this.getObject().getLayoutParams();
		lp.left = left;
		this.getObject().getParent().requestLayout();
	}
	@Override
	public int getLeft()	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)this.getObject().getLayoutParams();
		return lp.left;
	}
	@Override
	public void setTop(int top)	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)this.getObject().getLayoutParams();
		lp.top = top;
		this.getObject().getParent().requestLayout();
	}
	@Override
	public int getTop()	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)this.getObject().getLayoutParams();
		return lp.top;
	}
	
	
}
