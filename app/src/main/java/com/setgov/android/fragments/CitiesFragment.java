package com.setgov.android.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.setgov.android.R;
import com.setgov.android.SimpleDividerItemDecoration;
import com.setgov.android.adapters.CityAdapter;
import com.setgov.android.models.City;
import com.setgov.android.models.User;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CitiesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CitiesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CitiesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String TAG = "CitiesFragment" ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @InjectView(R.id.citiesRecyclerView)
    public RecyclerView citiesView;
    private ArrayList<City> mCities;
    private GridLayoutManager mCityLayoutManager;
    private CityAdapter mCityAdapter;

    private OnFragmentInteractionListener mListener;
    private User mUser;

    public CitiesFragment() {
        // Required empty public constructor
    }

    public static CitiesFragment newInstance(User user) {
        CitiesFragment fragment = new CitiesFragment();
        Bundle args = new Bundle();
        args.putSerializable("User", user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUser = (User)getArguments().getSerializable("User");
        mCities = new ArrayList<>();
        City fortlauderdale = new City("Fort Lauderdale","Florida","Broward","FL");
        City boston = new City("Boston","Massachusetts","Suffolk","MA");
       // City newyork = new City("New York","New York","New York","NY");
        City phoenix = new City("Phoenix","Arizona","Maricopa","AZ");
        City miami = new City("Miami","Florida","Miami-Dade","FL");
        City austin = new City("Austin","Texas","Travis","TX");
        City sanjose = new City("San Jose","California","Santa Carla","CA");

        mCities.add(fortlauderdale);
        mCities.add(boston);
        mCities.add(phoenix);
        mCities.add(miami);
        mCities.add(sanjose);
        mCities.add(austin);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cities, container, false);
        ButterKnife.inject(this,view);
        mCityLayoutManager = new GridLayoutManager(getActivity(), 2);
        citiesView.setLayoutManager(mCityLayoutManager);
        citiesView.addItemDecoration(new SimpleDividerItemDecoration(getActivity(),true));
        mCityAdapter = new CityAdapter(mUser, citiesView,getActivity(), mCities);
        citiesView.setAdapter(mCityAdapter);
        TextView toolbarTitle = (TextView) getActivity().findViewById(R.id.toolbarTitle);
        toolbarTitle.setText(R.string.chooseyourcity);
        ImageView toolbarImage = (ImageView) getActivity().findViewById(R.id.settingsButton);
        toolbarImage.setVisibility(View.GONE);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
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
    }

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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
