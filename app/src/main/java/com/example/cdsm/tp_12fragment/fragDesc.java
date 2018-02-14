package com.example.cdsm.tp_12fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragDesc.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class fragDesc extends Fragment {

    View v;
    ImageView imageAnim;
    TextView descAnim;

    public fragDesc() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.fragment_frag_desc, container, false);
        // Inflate the layout for this fragment
        return v;
    }

    public void onActivityCreated(Bundle savedState)
    {

        super.onActivityCreated(savedState);
        imageAnim = (ImageView) v.findViewById(R.id.imageviewAnimal);
        descAnim = (TextView) v.findViewById(R.id.tvDescAnimal);

        try
        {
            Intent intent = getActivity().getIntent();
            String Anim = intent.getStringExtra("type");

            if (Anim.equals("Chien"))
            {
                setChien();
            }
            else
            {
                setChat();
            }
        }
        catch (NullPointerException e)
        {

        }
        Log.i("Main","TestLog");


    }

    public void setChien()
    {
        imageAnim.setImageResource(R.drawable.chien);
        Scanner scan =  new Scanner(getResources().openRawResource(R.raw.chien));
        descAnim.setText(scan.nextLine());
        scan.close();
    }

    public void setChat()
    {
        imageAnim.setImageResource(R.drawable.chat);
        Scanner scan =  new Scanner(getResources().openRawResource(R.raw.chat));
        descAnim.setText(scan.nextLine());
        scan.close();
    }

    // TODO: Rename method, update argument and hook method into UI event



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
