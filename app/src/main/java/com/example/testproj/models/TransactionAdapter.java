package com.example.testproj.models;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproj.DetailedTransactionHistory;
import com.example.testproj.R;
import com.example.testproj.TransactionConstants;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {
    private ArrayList<TransactionData.Datum> transactionList;
    private Context context;

    public TransactionAdapter(ArrayList<TransactionData.Datum> transactionList, Context context) {
        this.transactionList = transactionList;
        this.context = context;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction, parent, false);
        return new TransactionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.TransactionViewHolder holder, int position) {
        TransactionData.Datum transaction = transactionList.get(position);

        DecimalFormat df = new DecimalFormat("0.00");
        String originalDateString = transaction.getTransactioN_DATE();
        Log.d("Transaction Date", originalDateString);

        SimpleDateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a", Locale.US);

        String formattedDate = null;
        try {
            Date date = originalFormat.parse(originalDateString);
            SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a", Locale.US);
            formattedDate = newFormat.format(date);

            System.out.println("Original Date: " + originalDateString);
            System.out.println("Formatted Date: " + formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Bind data to views in the ViewHolder
        holder.txtItemAmount.setText("- ₹" + df.format(Double.parseDouble(transaction.getAmount())));
        holder.txtItemName.setText(transaction.getVpa_id());
        holder.txtItemDate.setText(formattedDate);
        holder.txtItemRefId.setText(transaction.getRefId());
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    //    @SuppressLint("NotifyDataSetChanged")
//    public void filter(String text) {
//        filteredList.clear();
//        if (text.isEmpty()) {
//            filteredList.addAll(transactionList);
//        } else {
//            text = text.toLowerCase().trim();
//            Log.d("entered text", text);
//            for (TransactionData.Datum transaction : transactionList) {
//                if (transaction.getVpa_id().toLowerCase().contains(text)) {
//                    filteredList.add(transaction);
//                    Log.d("filtered list size", Integer.toString(filteredList.size()));
//                }
//            }
//        }
//        notifyDataSetChanged();
//    }

    public TransactionData.Datum getItem(int position) {
        return transactionList.get(position);
    }

    // Method to get the filtered list
    public List<TransactionData.Datum> getFilteredList() {
        return transactionList;
    }

    // Method to update the adapter data
    public void updateData(List<TransactionData.Datum> transactions) {
        transactionList.clear();
        transactionList.addAll(transactions);
//        filter(""); // Reset filter with an empty string to display all items
    }

    public void clearList() {
        transactionList.clear();
        notifyDataSetChanged();
//        filter(""); // Reset filter with an empty string to display all items
    }

    class TransactionViewHolder extends RecyclerView.ViewHolder {

        TextView txtItemAmount, txtItemName, txtItemDate, txtItemRefId;
        LinearLayout transactionItemBtn;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            txtItemAmount = itemView.findViewById(R.id.txtItemAmount);
            txtItemName = itemView.findViewById(R.id.txtItemName);
            txtItemDate = itemView.findViewById(R.id.txtTrxnDate);
            txtItemRefId = itemView.findViewById(R.id.txtItemRefId);
            transactionItemBtn = itemView.findViewById(R.id.transactionItemBtn);

            transactionItemBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        TransactionData.Datum clickedTransaction = transactionList.get(position);

                        String originalDateString = clickedTransaction.getTransactioN_DATE();
                        Log.d("Transaction Date", originalDateString);

                        SimpleDateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a", Locale.US);

                        String formattedDate = null;
                        try {
                            Date date = originalFormat.parse(originalDateString);
                            SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a", Locale.US);
                            formattedDate = newFormat.format(date);

                            System.out.println("Original Date: " + originalDateString);
                            System.out.println("Formatted Date: " + formattedDate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(context, DetailedTransactionHistory.class);
                        intent.putExtra(TransactionConstants.AMOUNT, clickedTransaction.getAmount());
                        intent.putExtra(TransactionConstants.USDT_AMOUNT, clickedTransaction.getAmountInUSD());
                        intent.putExtra(TransactionConstants.DATE, formattedDate);
                        intent.putExtra(TransactionConstants.VPA_ID, clickedTransaction.getVpa_id());
                        intent.putExtra(TransactionConstants.REF_ID, clickedTransaction.getRefId());
                        intent.putExtra(TransactionConstants.REMARK, clickedTransaction.getRemarks());
                        intent.putExtra(TransactionConstants.STATUS, clickedTransaction.getMessage());
                        intent.putExtra(TransactionConstants.MODE, clickedTransaction.getMode());
                        context.startActivity(intent);
                    }
                }
            });

        }
    }
}
