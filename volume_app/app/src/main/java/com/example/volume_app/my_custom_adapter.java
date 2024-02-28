package com.example.volume_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class my_custom_adapter extends ArrayAdapter<shape> {
    /*
    The custom adapter extending ArrayAdapter n android allows
    you to create a specialized adapter for populating UI element
    like list view,spinner or grid view with data from an array or list of items.
    So this class will be responsible for creating the view for each item and binding
    data to it and since our data source is an array list.
     */
    private ArrayList<shape> shapesArrayList;
    Context context;
    /*
    Our data source is passed as an array list and the context object
    represents the current state and environment of our application
    */

    public my_custom_adapter( ArrayList<shape> shapesArrayList, Context context) {
        super(context, R.layout.grid_coustom_layout,shapesArrayList);
        this.shapesArrayList = shapesArrayList;
        this.context=context;
    }
    /*
    The view holder class --is used to cache reference to the views
    within an item layout so that they don't need to be repeatedly
    looked up during scrolling.
     */
    private static class MyViewHolder
    {
        TextView shapeName;
        ImageView shapeImg;
    }
    //GetView(): Used to create and return a view for a specific item in Grid.

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       /*
       The first parameter,the position of type N.It stores the position of the item
       within the data set that should be displayed.The second parameter is the
       convert view,which is of type view,a recycled  view that went off screen and can be
       reused if convert a view is null,it indicates that there is no view available
       for recycling.you need to inflate a new one and this is what we're going to check null or not.
       The third parameter is the parent,which is of type view group,the parent of view group that
       will eventually hold the returned view.
        */
        //1-get the shape object for current position
        shape shapes=getItem(position);
        //2-Inflating Layout
        MyViewHolder myViewHolder;
        if(convertView==null){
            //no view went off-screen-->create a new view
            myViewHolder=new MyViewHolder();
            /*
            the layout inflater is a utility class that it is used to instantiate XML layout files
            and convert them into corresponding view objects.Its a fundamental component of android's
            framework that allows you to define the structure and appearance of our app's
            user interface using XML, and then inflate those layout at runtime to create the actual
            virtual element.So the process of creating the view objects from the XML layout
            files is known as inflating.
             */
            LayoutInflater inflater =LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.grid_coustom_layout,
                    parent,
                    false
            /*
            this false is attached to root a boolean flag indicating whether the inflated
            view should be attached to the parent view group immediately.If it is set to false,
            we can manually add it later.And if it is true, the inflate view become a part of the UI
            hierarchy,then we need to find the views
             */
            );
            //finding the view
            myViewHolder.shapeName=(TextView) convertView.findViewById(R.id.textView);
            myViewHolder.shapeImg=(ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(myViewHolder);
        }
        else{
            //a view went off-screen -->re-useit

            myViewHolder =(MyViewHolder) convertView.getTag();
        }
        //getting the data from the model class(shape)
        myViewHolder.shapeName.setText(shapes.getShapeName());
        myViewHolder.shapeImg.setImageResource(shapes.getShapeImg());
        return convertView;
    }
}
