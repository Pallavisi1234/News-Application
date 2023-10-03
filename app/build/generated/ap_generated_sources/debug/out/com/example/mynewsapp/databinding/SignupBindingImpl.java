package com.example.mynewsapp.databinding;
import com.example.mynewsapp.R;
import com.example.mynewsapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class SignupBindingImpl extends SignupBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvSignUp, 1);
        sViewsWithIds.put(R.id.ivDP, 2);
        sViewsWithIds.put(R.id.username, 3);
        sViewsWithIds.put(R.id.email, 4);
        sViewsWithIds.put(R.id.password, 5);
        sViewsWithIds.put(R.id.repassword, 6);
        sViewsWithIds.put(R.id.Signupbtn, 7);
        sViewsWithIds.put(R.id.btnlogin, 8);
        sViewsWithIds.put(R.id.info, 9);
        sViewsWithIds.put(R.id.icons, 10);
        sViewsWithIds.put(R.id.google, 11);
        sViewsWithIds.put(R.id.fb, 12);
        sViewsWithIds.put(R.id.pbLoading, 13);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public SignupBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private SignupBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.button.MaterialButton) bindings[7]
            , (android.widget.Button) bindings[8]
            , (android.widget.EditText) bindings[4]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.TextView) bindings[9]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[2]
            , (android.widget.EditText) bindings[5]
            , (android.widget.ProgressBar) bindings[13]
            , (android.widget.EditText) bindings[6]
            , (android.widget.TextView) bindings[1]
            , (android.widget.EditText) bindings[3]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}