package com.example.cdsm.tp_12fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragAnim.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class fragAnim extends Fragment {

    ImageButton Btn_Chien;
    ImageButton Btn_Chat;
    View v;

    //private OnFragmentInteractionListener mListener;

    /*public fragAnim() {
        // Required empty public constructor
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.fragment_frag_anim, container, false);
        return v;
    }

    public void onActivityCreated(Bundle savedState)
    {
        super.onActivityCreated(savedState);
        Btn_Chien = (ImageButton) v.findViewById(R.id.buttonChien);
        Btn_Chat = (ImageButton) v.findViewById(R.id.buttonChat);
        final Intent intent = new Intent(getActivity(),DescActivity.class);

        Btn_Chien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(getActivity().getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE)
                {
                    intent.putExtra("type","Chien");
                    startActivity(intent);
                }
                else
                {
                    fragDesc fragment = (fragDesc) getActivity().getFragmentManager().findFragmentById(R.id.fragDesc);
                    fragment.setChien();
                }
            }
        });
        Btn_Chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(getActivity().getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE)
                {
                    intent.putExtra("type","Chat");
                    startActivity(intent);
                }
                else
                {
                    fragDesc fragment = (fragDesc) getActivity().getFragmentManager().findFragmentById(R.id.fragDesc);
                    fragment.setChat();
                }
            }
        });
    }



    /* TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }/*

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
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
