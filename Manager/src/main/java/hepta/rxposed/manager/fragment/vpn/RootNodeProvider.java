package hepta.rxposed.manager.fragment.vpn;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import hepta.rxposed.manager.R;

public class RootNodeProvider extends BaseNodeProvider {

    @Override
    public int getItemViewType() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_inject_user;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, @NotNull BaseNode baseNode) {
        // 数据类型需要自己强转
        RootNode entity = (RootNode) baseNode;
        baseViewHolder.setText(R.id.user_id, entity.getUid());
        baseViewHolder.setText(R.id.user_name, entity.getUserName());
//        baseViewHolder.setText(R.id.description, entity.getPkgName());
        Drawable icon = entity.getIcon();
        if(icon !=null){
            baseViewHolder.setImageDrawable(R.id.app_icon, icon);

        }
    }

    @Override
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, BaseNode data, int position) {
        getAdapter().expandOrCollapse(position);
    }
}
